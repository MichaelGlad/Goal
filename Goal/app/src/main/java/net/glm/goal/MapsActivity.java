package net.glm.goal;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;


import net.glm.goal.Interfaces.DirectionNetworkClient;
import net.glm.goal.Pojo.DirectionAnswer;
import net.glm.goal.Pojo.Polyline;
import net.glm.goal.Pojo.Route;
import net.glm.goal.Pojo.Step;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static net.glm.goal.Utility.BitmapUtility.*;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        LocationListener {

    static final int PERMISSION_CODE = 102;
    static final String LOG_TAG = "Goal App ";

    private GoogleMap mMap;
    private boolean permissionIsGranted;
    private Marker currentLocationMarker;
    private Marker[] markersArray = new Marker [5];
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private BitmapDescriptor iconForMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        iconForMarker = BitmapDescriptorFactory.fromBitmap(
                getResizebleCircleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cat),
                        (int) (30 * getResources().getDisplayMetrics().density)));
        Log.d(LOG_TAG," Map Activity OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        initGoogleApiClient();
        googleApiClient.connect();
        Log.d(LOG_TAG," Map Activity OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }

    private void initGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Google Campus TLV and move the camera
        LatLng googleCampusTLV = new LatLng(32.0700804, 34.7941446);
        markersArray[0]=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(googleCampusTLV.latitude,googleCampusTLV.longitude))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("Start"));
        markersArray[0].setTag((Integer) 0);

        for (int i = 1; i < markersArray.length; i++) {
            markersArray[i] = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(googleCampusTLV.latitude+i*0.0003,googleCampusTLV.longitude+i*0.0003))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .draggable(true)
                    .title("Station " + i)
            );
            markersArray[i].setTag((Integer) i);

        }

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.our_style_json));

            if (!success) {
                Log.e(LOG_TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(LOG_TAG, "Can't find style. Error: ", e);
        }
        mMap.setOnMarkerClickListener(new MyMarkerClickListener());
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(googleCampusTLV,16));
    }

    private void requestLocationUpdate() {
        if (checkPermission()) {
            locationRequest = new LocationRequest();
            locationRequest.setInterval(2 * 1000);
            locationRequest.setFastestInterval(1000);
            locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        requestLocationUpdate();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(LOG_TAG, " Connection Suspended - ");

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(LOG_TAG, " Connection Failed : ConnectionResult.getErrorCode() = " + connectionResult.getErrorCode());

    }

    @Override
    public void onLocationChanged(Location location) {

//        currentLocationMarker.setPosition(new LatLng(location.getLatitude(),location.getLongitude()));

    }

    private boolean checkPermission() {
        if (permissionIsGranted) {
            return permissionIsGranted;
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);
            }
        } else permissionIsGranted = true;
        return permissionIsGranted;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                permissionIsGranted = true;
            } else {
                permissionIsGranted = false;
                Toast.makeText(this, " This App request location Permission to be granted ", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void runNetworkRequest(){
        Retrofit.Builder rBuilder = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/directions/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = rBuilder.build();
        DirectionNetworkClient directionClient = retrofit.create(DirectionNetworkClient.class);
        Call<DirectionAnswer> call = directionClient.getDirectionOnPath();

        call.enqueue(new Callback<DirectionAnswer>() {
            @Override
            public void onResponse(Call<DirectionAnswer> call, Response<DirectionAnswer> response) {
              DirectionAnswer directionAnswer = response.body();

                if(directionAnswer.routes.get(0).legs.get(0).steps != null){
                    List<Step> pathSteps = directionAnswer.routes.get(0).legs.get(0).steps;
                    List<String> polylineList = new ArrayList<>();
                    Log.d(LOG_TAG,"Number of Legs  - " + directionAnswer.routes.get(0).legs.size());
                    for (int i =0; i < pathSteps.size();i++){
                        polylineList.add(pathSteps.get(i).polyline.points);
                    }
                    drawDirectioOnMap(polylineList);
                }
                Toast.makeText(MapsActivity.this,"The Length of Path -" +
                                directionAnswer.routes.get(0).legs.get(0).distance.stringDistance,
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<DirectionAnswer> call, Throwable t) {

                Toast.makeText(MapsActivity.this," Network access faild",Toast.LENGTH_SHORT).show();


            }
        });


    }

    public void drawDirectioOnMap (List<String> polylineList){

        for (int i = 0; i < polylineList.size() ; i++) {
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(getResources().getColor(R.color.colorGreenMain));
            polylineOptions.width(10);
            polylineOptions.addAll(PolyUtil.decode(polylineList.get(i)));
            mMap.addPolyline(polylineOptions);
        }
    }

    public class MyMarkerClickListener implements GoogleMap.OnMarkerClickListener{

        @Override
        public boolean onMarkerClick(Marker marker) {

            Log.d(LOG_TAG," The Marker is - " + marker.getTag().toString());
            if(marker.getTag() != null) {
                if(((Integer) marker.getTag()) == 1){
                    runNetworkRequest();
                }
            }
            return false;
        }
    }


}

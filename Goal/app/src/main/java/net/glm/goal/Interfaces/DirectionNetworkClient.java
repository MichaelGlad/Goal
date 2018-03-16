package net.glm.goal.Interfaces;

import net.glm.goal.Pojo.DirectionAnswer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Michael on 3/16/2018.
 */

public interface DirectionNetworkClient {
    @GET("json?origin=32.0700804,34.7941446&destination=32.0750804,34.7991446&mode=walking&key=AIzaSyDYsW4J4yCuDmkAqCBONWCoYyI98PeZq24")
    Call<DirectionAnswer> getDirectionOnPath(    );
}

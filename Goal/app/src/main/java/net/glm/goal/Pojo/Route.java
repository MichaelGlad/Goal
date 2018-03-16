
package net.glm.goal.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("legs")
    @Expose
    public List<Leg> legs = null;
    @SerializedName("overview_polyline")
    @Expose
    public OverviewPolyline overviewPolyline;




}

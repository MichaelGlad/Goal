
package net.glm.goal.Pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leg {

    @SerializedName("distance")
    @Expose
    public Distance distance;
    @SerializedName("duration")
    @Expose
    public Duration duration;
    @SerializedName("end_location")
    @Expose
    public EndLocation endLocation;

    @SerializedName("start_location")
    @Expose
    public StartLocation startLocation;
    @SerializedName("steps")
    @Expose
    public List<Step> steps = null ;

}

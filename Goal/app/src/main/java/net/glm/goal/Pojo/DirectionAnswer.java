package net.glm.goal.Pojo;

/**
 * Created by Michael on 3/15/2018.
 */

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DirectionAnswer {

    @SerializedName("routes")
    @Expose
    public List<Route> routes = null;

}

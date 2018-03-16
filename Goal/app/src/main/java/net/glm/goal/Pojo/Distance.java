
package net.glm.goal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Distance {

    @SerializedName("text")
    @Expose
    public String stringDistance;

    @SerializedName("value")
    @Expose
    public Long distance;


}

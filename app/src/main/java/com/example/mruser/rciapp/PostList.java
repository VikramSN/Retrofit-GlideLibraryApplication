
package com.example.mruser.rciapp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostList {

    @SerializedName("worldpopulation")
    @Expose
    private List<Worldpopulation> worldpopulation = null;

    public List<Worldpopulation> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(List<Worldpopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

   /* @Override
    public String toString() {
        return new ToStringBuilder(this).append("worldpopulation", worldpopulation).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(worldpopulation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostList) == false) {
            return false;
        }
        PostList rhs = ((PostList) other);
        return new EqualsBuilder().append(worldpopulation, rhs.worldpopulation).isEquals();
    }*/

}


package com.example.mruser.rciapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
*/

public class Worldpopulation {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("flag")
    @Expose
    private String flag;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /*@Override
    public String toString() {
        return new ToStringBuilder(this).append("rank", rank).append("country", country).append("population", population).append("flag", flag).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rank).append(flag).append(population).append(country).toHashCode();
    }*/

   // @Override
  /*  public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Worldpopulation) == false) {
            return false;
        }
        Worldpopulation rhs = ((Worldpopulation) other);
        return new EqualsBuilder().append(rank, rhs.rank).append(flag, rhs.flag).append(population, rhs.population).append(country, rhs.country).isEquals();
    }*/

}

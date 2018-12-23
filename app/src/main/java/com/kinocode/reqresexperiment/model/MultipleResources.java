
package com.kinocode.reqresexperiment.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class MultipleResources {

    @SerializedName("page")
    public Integer page;

    @SerializedName("per_page")
    public Integer perPage;

    @SerializedName("total")
    public Integer total;

    @SerializedName("total_pages")
    public Integer totalPages;

    @SerializedName("data")
    public List<Datum> data = null;

   public class Datum {

       @SerializedName("id")
       public Integer id;

       @SerializedName("name")
       public String name;

       @SerializedName("year")
       public Integer year;

       @SerializedName("color")
       public String color;

       @SerializedName("pantone_value")
       public String pantoneValue;

   }

}

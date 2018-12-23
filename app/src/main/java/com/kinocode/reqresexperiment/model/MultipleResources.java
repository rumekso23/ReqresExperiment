package com.kinocode.reqresexperiment.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class MultipleResources {

    @SerializedName("data")
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

   public class Datum {

       @SerializedName("id")
       public Integer id;

       @SerializedName("name")
       public String name;

       @SerializedName("year")
       public String year;

       @SerializedName("color")
       public String color;

       @SerializedName("pantone_value")
       public String pantoneValue;

       public Datum (Integer id, String name, String year, String color, String pantoneValue){
           this.id = id;
           this.name = name;
           this.year = year;
           this.color = color;
           this.pantoneValue = pantoneValue;
       }

       public Integer getId() {
           return id;
       }

       public void setId(Integer id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getYear() {
           return year;
       }

       public void setYear(String year) {
           this.year = year;
       }

       public String getColor() {
           return color;
       }

       public void setColor(String color) {
           this.color = color;
       }

       public String getPantoneValue() {
           return pantoneValue;
       }

       public void setPantoneValue(String pantoneValue) {
           this.pantoneValue = pantoneValue;
       }
   }

}

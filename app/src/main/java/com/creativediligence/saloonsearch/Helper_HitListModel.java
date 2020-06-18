package com.creativediligence.saloonsearch;

public class Helper_HitListModel {

    private String saloonName;
    private String salonLocation;
    private String saloonRating;

    public Helper_HitListModel(String saloonName, String salonLocation, String saloonRating) {
        this.saloonName = saloonName;
        this.salonLocation = salonLocation;
        this.saloonRating = saloonRating;
    }

    public String getSaloonName() {
        return saloonName;
    }

    public String getSalonLocation() {
        return salonLocation;
    }

    public String getSaloonRating() {
        return saloonRating;
    }


}

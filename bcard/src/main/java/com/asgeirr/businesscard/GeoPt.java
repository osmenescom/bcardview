package com.asgeirr.businesscard;

import androidx.annotation.NonNull;

public class GeoPt {
    private float latitude;
    private float longitude;

    public GeoPt(){}

    public GeoPt(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @NonNull
    @Override
    public GeoPt clone(){
        try {
            return (GeoPt) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new GeoPt();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null ) return false;
        if (!(obj instanceof GeoPt)) return false;
        GeoPt geoPt = (GeoPt) obj;
        return latitude == geoPt.getLatitude() &&
                longitude == geoPt.getLongitude();
    }
}

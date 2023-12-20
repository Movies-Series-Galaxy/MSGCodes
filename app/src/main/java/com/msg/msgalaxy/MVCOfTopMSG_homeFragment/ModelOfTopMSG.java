package com.msg.msgalaxy.MVCOfTopMSG_homeFragment;

public class ModelOfTopMSG {

    private String topMSGPicUrl;
    private String topMSGTrailerUrl;
    private String type;
    private String year;
    private String imdbRating;

    public ModelOfTopMSG(String topMSGPicUrl, String topMSGTrailerUrl, String type, String year, String imdbRating) {
        this.topMSGPicUrl = topMSGPicUrl;
        this.topMSGTrailerUrl = topMSGTrailerUrl;
        this.type = type;
        this.year = year;
        this.imdbRating = imdbRating;
    }

    public String getTopMSGPicUrl() {
        return topMSGPicUrl;
    }

    public void setTopMSGPicUrl(String topMSGPicUrl) {
        this.topMSGPicUrl = topMSGPicUrl;
    }

    public String getTopMSGTrailerUrl() {
        return topMSGTrailerUrl;
    }

    public void setTopMSGTrailerUrl(String topMSGTrailerUrl) {
        this.topMSGTrailerUrl = topMSGTrailerUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }
}

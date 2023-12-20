package com.msg.msgalaxy.MVCOfTopRated;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ModelOfTopRatedMovies {

    private String picture;
    private String rank , name;
    private String type , year , duration , rating;
    private String trailerUrl;
    private String description;
    private String directorPicture , star1Picture , star2Picture , star3Picture;
    private String directorName , star1Name , star2Name , star3Name;

    public ModelOfTopRatedMovies() {
    }

    public ModelOfTopRatedMovies(String picture, String rank, String name, String year, String duration, String rating) {
        this.picture = picture;
        this.rank = rank;
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
    }

    public ModelOfTopRatedMovies(String picture, String rank, String name, String type, String year, String duration, String rating, String trailerUrl, String description, String directorName) {
        this.picture = picture;
        this.rank = rank;
        this.name = name;
        this.type = type;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.trailerUrl = trailerUrl;
        this.description = description;
        this.directorName = directorName;
    }

    public ModelOfTopRatedMovies(String picture, String rank, String name, String type, String year, String duration, String rating, String trailerUrl, String description, String directorPicture, String star1Picture, String star2Picture, String star3Picture, String directorName, String star1Name, String star2Name, String star3Name) {
        this.picture = picture;
        this.rank = rank;
        this.name = name;
        this.type = type;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.trailerUrl = trailerUrl;
        this.description = description;
        this.directorPicture = directorPicture;
        this.star1Picture = star1Picture;
        this.star2Picture = star2Picture;
        this.star3Picture = star3Picture;
        this.directorName = directorName;
        this.star1Name = star1Name;
        this.star2Name = star2Name;
        this.star3Name = star3Name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirectorPicture() {
        return directorPicture;
    }

    public void setDirectorPicture(String directorPicture) {
        this.directorPicture = directorPicture;
    }

    public String getStar1Picture() {
        return star1Picture;
    }

    public void setStar1Picture(String star1Picture) {
        this.star1Picture = star1Picture;
    }

    public String getStar2Picture() {
        return star2Picture;
    }

    public void setStar2Picture(String star2Picture) {
        this.star2Picture = star2Picture;
    }

    public String getStar3Picture() {
        return star3Picture;
    }

    public void setStar3Picture(String star3Picture) {
        this.star3Picture = star3Picture;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStar1Name() {
        return star1Name;
    }

    public void setStar1Name(String star1Name) {
        this.star1Name = star1Name;
    }

    public String getStar2Name() {
        return star2Name;
    }

    public void setStar2Name(String star2Name) {
        this.star2Name = star2Name;
    }

    public String getStar3Name() {
        return star3Name;
    }

    public void setStar3Name(String star3Name) {
        this.star3Name = star3Name;
    }
}

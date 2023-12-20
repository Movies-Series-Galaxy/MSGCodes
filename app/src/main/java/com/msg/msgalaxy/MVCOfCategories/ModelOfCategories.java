package com.msg.msgalaxy.MVCOfCategories;

public class ModelOfCategories {

    private String categoriePicUrl;
    private String categorieName;
    private String categorieBackgroundUrl;

    public ModelOfCategories(String categoriePicUrl, String categorieName, String categorieBackgroundUrl) {
        this.categoriePicUrl = categoriePicUrl;
        this.categorieName = categorieName;
        this.categorieBackgroundUrl = categorieBackgroundUrl;
    }

    public String getCategoriePicUrl() {
        return categoriePicUrl;
    }

    public void setCategoriePicUrl(String categoriePicUrl) {
        this.categoriePicUrl = categoriePicUrl;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public String getCategorieBackgroundUrl() {
        return categorieBackgroundUrl;
    }

    public void setCategorieBackgroundUrl(String categorieBackgroundUrl) {
        this.categorieBackgroundUrl = categorieBackgroundUrl;
    }
}

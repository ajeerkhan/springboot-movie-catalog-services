package io.spring.ajeer.moviecatalogservice.model;

public class CatalogItem {
    private String name;
    private String desc;
    private int rating;

    public CatalogItem() {
    }
    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String name) {
        this.name = name;
    }

    public int  getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        this.setRating(rating);
    }
}

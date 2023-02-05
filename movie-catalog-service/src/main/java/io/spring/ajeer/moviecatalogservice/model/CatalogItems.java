package io.spring.ajeer.moviecatalogservice.model;

import java.util.List;

public class CatalogItems {
    private String userId;
    private List<CatalogItem> catalogItems;
    public CatalogItems(){}
    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

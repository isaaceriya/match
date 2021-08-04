package com.fsbtech.interviews.entities;

public class Clientmodel {
    Category category;
    Event event;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public MarketRefType getMarketRefType() {
        return marketRefType;
    }

    public void setMarketRefType(MarketRefType marketRefType) {
        this.marketRefType = marketRefType;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    MarketRefType marketRefType;
    SubCategory subCategory;
}

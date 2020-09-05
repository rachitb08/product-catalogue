package com.shoppingcart.productcatalogue.constants;

public enum EnumFilterType {
    BRAND("brand"),CATEGORY("category");

    private String name;

    EnumFilterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

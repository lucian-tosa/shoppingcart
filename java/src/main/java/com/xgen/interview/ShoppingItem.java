package com.xgen.interview;

import java.util.Objects;

public class ShoppingItem {
    private final String itemType;

    public ShoppingItem(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItem that = (ShoppingItem) o;
        return Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemType);
    }
}

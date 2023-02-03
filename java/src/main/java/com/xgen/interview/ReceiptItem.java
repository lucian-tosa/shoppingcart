package com.xgen.interview;

import java.util.Objects;

public class ReceiptItem {
    ShoppingItem item;
    int order;
    int amount;
    Double price;

    public ReceiptItem(ShoppingItem item, int order, int amount, Double price) {
        this.item = item;
        this.order = order;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return amount == that.amount && Objects.equals(item, that.item) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, amount, price);
    }
}

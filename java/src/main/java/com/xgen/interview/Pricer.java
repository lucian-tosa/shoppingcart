package com.xgen.interview;

import java.util.HashMap;


/**
 * A stub implementation - for this exercise, you may disregard that this is incomplete.
 */
public class Pricer {
    HashMap<ShoppingItem, Double> pricingDatabase = new HashMap<>(); // stub
    HashMap<String, ShoppingItem> nameDatabase = new HashMap<>();

    public Pricer() {
        addItem("apple", 1.00);
        addItem("banana", 2.00);
    }

    public ShoppingItem findItem(String itemType) {
        if(!nameDatabase.containsKey(itemType))
            addItem(itemType, 0.0);
        return nameDatabase.get(itemType);
    }

    //TODO : add proper error handling using exceptions
    public void addItem(String itemType, Double price) {
        if(!nameDatabase.containsKey(itemType)) {
            nameDatabase.put(itemType, new ShoppingItem(itemType));
        }
        pricingDatabase.put(findItem(itemType), Math.max(price, 0.0));
    }

    /**
     * Returns the price of the item passed, in Euro-cent. Eg. if an item costs €1, this will return 100
     * If itemType is an unknown string, store policy is that the item is free.
     */
    public Double getPrice(String itemType) {
        if (!nameDatabase.containsKey(itemType)) {
            return 0.0;
        }
        return pricingDatabase.get(findItem(itemType));
    }

}

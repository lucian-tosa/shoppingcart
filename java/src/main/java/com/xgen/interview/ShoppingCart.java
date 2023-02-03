package com.xgen.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * This is the current implementation of ShoppingCart.
 * Please write a replacement
 */
public class ShoppingCart implements IShoppingCart {
    private final HashMap<ShoppingItem, ReceiptItem> contents = new HashMap<>();
    private final Pricer pricer;
    private ReceiptFormat formatter;

    public ShoppingCart(Pricer pricer, ReceiptFormat formatter) {
        this.pricer = pricer;
        this.formatter = formatter;
    }

    public void addItem(String itemType, int number) {
        if(number <= 0)
            return;
        ShoppingItem item = pricer.findItem(itemType);
        int currentAmount = 0;
        if(contents.containsKey(item))
            currentAmount = contents.get(item).amount;
        contents.put(item, new ReceiptItem(item, contents.size() + 1, currentAmount + number, pricer.getPrice(itemType)));

    }

    public void printReceipt() {
        List<ReceiptItem> receipt = new ArrayList<>(contents.values());
        receipt.sort(Comparator.comparingInt(x -> x.order));
        formatter.printReceipt(receipt);
    }

    public void setFormatter(ReceiptFormat formatter) {
        this.formatter = formatter;
    }

}

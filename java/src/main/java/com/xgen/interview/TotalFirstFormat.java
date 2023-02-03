package com.xgen.interview;

import java.util.List;

public class TotalFirstFormat implements ReceiptFormat{

    @Override
    public void printReceipt(List<ReceiptItem> receipt) {
        Double total = receipt.stream()
                .map(x -> x.price * x.amount)
                .reduce(0.0, Double::sum);

        receipt.forEach(x -> {
                    Double subtotal = x.amount * x.price;
                    System.out.println("€" +  String.format("%.02f", subtotal) + " - " + x.amount + " - " + x.item.getItemType());
                });

        System.out.print("TOTAL: €" + String.format("%.02f", total));
    }
}

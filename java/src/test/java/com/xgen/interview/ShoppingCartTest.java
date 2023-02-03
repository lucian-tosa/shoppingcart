package com.xgen.interview;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShoppingCartTest {

    ReceiptFormat format = mock(ReceiptFormat.class);

    @Test
    public void canAddAnItem() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("apple", 1);

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("apple"), 0, 1, 1.00));
        sc.printReceipt();
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void canAddMoreThanOneItem() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("apple", 2);

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("apple"), 0, 2, 1.00));
        sc.printReceipt();
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void canAddDifferentItems() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);

        sc.printReceipt();

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("apple"), 0, 2, 1.00),
                new ReceiptItem(new ShoppingItem("banana"), 2, 1, 2.00));
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void doesntExplodeOnMysteryItem() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("crisps", 2);

        sc.printReceipt();

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("crisps"), 0, 2, 0.0));
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void itemInOrder() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);
        sc.addItem("apple", 2);

        sc.printReceipt();

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("banana"), 1, 1, 2.00),
                new ReceiptItem(new ShoppingItem("apple"), 0, 4, 1.00));
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void negativeAmount() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), format);

        sc.addItem("apple", -2);

        sc.printReceipt();

        List<ReceiptItem> expected = List.of();
        verify(format, times(1)).printReceipt(expected);
    }

    @Test
    public void testFormatter() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), null);
        sc.setFormatter(format);

        sc.addItem("apple", 1);

        List<ReceiptItem> expected = List.of(new ReceiptItem(new ShoppingItem("apple"), 0, 1, 1.00));
        sc.printReceipt();
        verify(format, times(1)).printReceipt(expected);
    }
}



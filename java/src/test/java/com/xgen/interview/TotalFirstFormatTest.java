package com.xgen.interview;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TotalFirstFormatTest {

    @Test
    public void oneItem() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("apple", 1);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("€1.00 - 1 - apple%nTOTAL: €1.00"), myOut.toString());
    }

    @Test
    public void oneItemMultiple() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("apple", 2);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("€2.00 - 2 - apple%nTOTAL: €2.00"), myOut.toString());
    }

    @Test
    public void differentItems() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();

        String result = myOut.toString();

        assertEquals(String.format("€2.00 - 2 - apple%n€2.00 - 1 - banana%nTOTAL: €4.00"), result);
    }

    @Test
    public void itemsApperInOrderWithItemInBetween() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);
        sc.addItem("apple", 2);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();

        String result = myOut.toString();

        assertEquals(String.format("€2.00 - 1 - banana%n€4.00 - 4 - apple%nTOTAL: €6.00"), result);
    }

    @Test
    public void itemsAppearInOrder() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();

        String result = myOut.toString();

        assertEquals(String.format("€2.00 - 2 - apple%n€2.00 - 1 - banana%nTOTAL: €4.00"), result);
    }

    @Test
    public void unknownItem() {
        ShoppingCart sc = new ShoppingCart(new Pricer(), new TotalFirstFormat());

        sc.addItem("crisps", 2);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        sc.printReceipt();
        assertEquals(String.format("€0.00 - 2 - crisps%nTOTAL: €0.00"), myOut.toString());
    }

}
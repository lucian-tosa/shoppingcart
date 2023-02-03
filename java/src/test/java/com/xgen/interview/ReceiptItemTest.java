package com.xgen.interview;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptItemTest {

    @Test
    public void testConstructor() {
        ReceiptItem item = new ReceiptItem(null, 1, 1, 1.0);
        assertNotNull(item);
    }

    @Test
    public void testEquals() {
        ReceiptItem item = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 1.00);
        ReceiptItem item1 = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 1.00);
        ReceiptItem item2 = new ReceiptItem(new ShoppingItem("apple"), 2, 1, 1.00);
        ReceiptItem item3 = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 2.00);
        ReceiptItem item4 = new ReceiptItem(new ShoppingItem("apple"), 1, 2, 1.00);
        ReceiptItem item5 = new ReceiptItem(new ShoppingItem("banana"), 1, 1, 1.00);

        assertNotEquals(item, null);
        assertEquals(item, item);
        assertEquals(item, item1);
        assertEquals(item, item2);
        assertNotEquals(item, item3);
        assertNotEquals(item, item4);
        assertNotEquals(item, item5);
    }

    @Test
    public void testHashCode() {
        ReceiptItem item = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 1.00);
        ReceiptItem item1 = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 1.00);
        ReceiptItem item2 = new ReceiptItem(new ShoppingItem("apple"), 2, 1, 1.00);
        ReceiptItem item3 = new ReceiptItem(new ShoppingItem("apple"), 1, 1, 2.00);
        ReceiptItem item4 = new ReceiptItem(new ShoppingItem("apple"), 1, 2, 1.00);
        ReceiptItem item5 = new ReceiptItem(new ShoppingItem("banana"), 1, 1, 1.00);

        assertEquals(item.hashCode(), item1.hashCode());
        assertEquals(item.hashCode(), item2.hashCode());
        assertNotEquals(item.hashCode(), item3.hashCode());
        assertNotEquals(item.hashCode(), item4.hashCode());
        assertNotEquals(item.hashCode(), item5.hashCode());
    }

}
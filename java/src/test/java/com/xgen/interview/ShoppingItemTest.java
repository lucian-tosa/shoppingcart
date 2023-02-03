package com.xgen.interview;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingItemTest {

    @Test
    public void testConstructor() {
        ShoppingItem item = new ShoppingItem("apple");
        assertNotNull(item);
    }

    @Test
    public void testGetter() {
        ShoppingItem item = new ShoppingItem("apple");
        assertEquals("apple", item.getItemType());
    }

    @Test
    public void testEquals() {
        ShoppingItem item = new ShoppingItem("apple");
        ShoppingItem item1 = new ShoppingItem("apple");
        ShoppingItem item2 = new ShoppingItem("banana");

        assertEquals(item, item1);
        assertNotEquals(item, item2);
    }

    @Test
    public void testHashCode() {
        ShoppingItem item = new ShoppingItem("apple");
        ShoppingItem item1 = new ShoppingItem("apple");
        ShoppingItem item2 = new ShoppingItem("banana");

        assertEquals(item.hashCode(), item1.hashCode());
        assertNotEquals(item.hashCode(), item2.hashCode());
    }

}
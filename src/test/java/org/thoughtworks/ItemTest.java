package org.thoughtworks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void shouldCreateItem() {
        Item item = new Item("Some Book", 12.49, ItemType.BOOK);

        assertThat(item.getName(), is("Some Book"));
        assertThat(item.getPrice(), is(12.49));
        assertThat(item.getType(), is(ItemType.BOOK));
        assertFalse(item.isImported());
    }

    @Test
    public void shouldCreateImportedItem() {
        Item item = new Item("Some Book", 12.49, ItemType.BOOK, true);

        assertThat(item.getName(), is("Some Book"));
        assertThat(item.getPrice(), is(12.49));
        assertThat(item.getType(), is(ItemType.BOOK));
        assertTrue(item.isImported());
    }
}

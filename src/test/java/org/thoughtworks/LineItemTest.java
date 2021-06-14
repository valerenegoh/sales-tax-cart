package org.thoughtworks;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LineItemTest {

    @Test
    public void shouldCreateLineItem() {
        Item item = new Item("Some Book", 12.49, ItemType.BOOK);
        LineItem lineItem = new LineItem(item, 1);

        assertThat(lineItem.getItem(), is(item));
        assertThat(lineItem.getQuantity(), is(1));
    }

    @Test
    public void shouldGetNoTaxForTaxExemptedLineItem() {
        Item item = new Item("Some Book", 12.49, ItemType.BOOK);
        LineItem lineItem = new LineItem(item, 1);

        assertThat(lineItem.getTax(), is(BigDecimal.ZERO));
    }

    @Test
    public void shouldGetBasicSalesTaxForSingleNonTaxExemptedLineItem() {
        Item item = new Item("Taylor Swift", 14.99, ItemType.MUSIC_CD);
        LineItem lineItem = new LineItem(item, 1);

        assertThat(lineItem.getTax(), is(BigDecimal.valueOf(1.5)));
    }

    @Test
    public void shouldGetBasicSalesTaxForMultipleNonTaxExemptedLineItem() {
        Item item = new Item("Taylor Swift", 14.99, ItemType.MUSIC_CD);
        LineItem lineItem = new LineItem(item, 2);

        assertEquals(0, BigDecimal.valueOf(3).compareTo(lineItem.getTax()));
    }

    @Test
    public void shouldGetBasicSalesAndImportDutyTaxForSingleNonTaxExemptedLineItem() {
        Item item = new Item("Vistoria Secret", 27.99, ItemType.PERFUME, true);
        LineItem lineItem = new LineItem(item, 1);

        assertThat(lineItem.getTax(), is(BigDecimal.valueOf(4.2)));
    }
}

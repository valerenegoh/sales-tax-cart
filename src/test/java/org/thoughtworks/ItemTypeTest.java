package org.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTypeTest {
    @Test
    public void shouldReturnTrueForTaxExemptedItems() {
        assertTrue(ItemType.BOOK.isTaxExempted());
        assertTrue(ItemType.FOOD.isTaxExempted());
        assertTrue(ItemType.MEDICAL.isTaxExempted());
    }

    @Test
    public void shouldReturnFalseForNonTaxExemptedItems() {
        assertFalse(ItemType.MUSIC_CD.isTaxExempted());
        assertFalse(ItemType.PERFUME.isTaxExempted());
    }
}

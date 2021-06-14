package org.thoughtworks;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LineItem {
    public static final BigDecimal BASIC_SALES_TAX = BigDecimal.valueOf(0.1);
    private static final BigDecimal IMPORT_DUTY = BigDecimal.valueOf(0.05);
    private Item item;
    private int quantity;

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTax() {
        if (item.getType().isTaxExempted()) return BigDecimal.ZERO;

        BigDecimal itemPrice = BigDecimal.valueOf(item.getPrice()).multiply(BigDecimal.valueOf(quantity));
        BigDecimal salesTax = itemPrice.multiply(BASIC_SALES_TAX);

        BigDecimal importTax = BigDecimal.ZERO;
        if (item.isImported()) {
            importTax = itemPrice.multiply(IMPORT_DUTY);
        }

        BigDecimal totalTax = salesTax.add(importTax);

        return totalTax.round(new MathContext(2, RoundingMode.HALF_UP));
    }
}

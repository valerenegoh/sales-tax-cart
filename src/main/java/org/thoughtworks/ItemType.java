package org.thoughtworks;

public enum ItemType {
    BOOK, MUSIC_CD, FOOD, MEDICAL, PERFUME;
    public boolean isTaxExempted() {
        return this.equals(BOOK) || this.equals(FOOD) || this.equals(MEDICAL);
    };
}

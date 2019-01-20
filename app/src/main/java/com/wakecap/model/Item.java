package com.wakecap.model;

public class Item implements Comparable<Item>{
    private long id;
    private ItemAttributes attributes;

    public long getId() {
        return id;
    }

    public ItemAttributes getAttributes() {
        return attributes;
    }

    @Override
    public int compareTo(Item item) {
        return attributes.getRole().compareTo(item.getAttributes().getRole());
    }
}

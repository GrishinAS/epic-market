package com.innteam.epicmarket.product;

public record Product(
        String description,
        String imgLink,
        double price,
        double rating) {}

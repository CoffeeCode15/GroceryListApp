package com.example.grocerylistapp;

public enum Category {
    FRUTTA("Frutta"),
    VERDURE("Verdure"),
    PASTICCERIA("Pasticceria"),
    LATTICINI("Latticini"),
    CARNE("Carne"),
    PESCE("Pesce"),
    CONSUMO("Oggetti di Consumo");

    private String text;

    Category(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Category fromString(String text) {
        for (Category b : Category.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
    }

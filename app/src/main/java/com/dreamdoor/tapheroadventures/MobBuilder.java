package com.dreamdoor.tapheroadventures;

public class MobBuilder {

    private String name;
    private int imageloc;
    private int health;
    private int maxHealth;

    public MobBuilder(String name, int imageloc, int health, int maxHealth) {
        this.name = name;
        this.imageloc = imageloc;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getImageloc() {
        return imageloc;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

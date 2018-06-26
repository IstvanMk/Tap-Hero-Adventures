package com.dreamdoor.tapheroadventures;

public class DamageAnimate {
    private int damage;
    private int x;
    private int y;

    public  DamageAnimate(int damage, int x, int y)
    {
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y++;
    }

    public int getDamage()
    {
        return damage;
    }

}

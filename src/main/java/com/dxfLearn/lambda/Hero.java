package com.dxfLearn.lambda;

public class Hero {

    public String name;
    public int hp;
    public int damage;


    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDemage() {
        return damage;
    }

    public void setDemage(int demage) {
        this.damage = demage;
    }

    public Hero(String name, int hp, int demage) {
        this.name = name;
        this.hp = hp;
        this.damage = demage;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

    public boolean matched(){
        return this.hp>100 && this.damage<50;
    }
}

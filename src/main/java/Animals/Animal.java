package Animals;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    public String name;
    public int price;
    public String type;
    private int age;
    private boolean gender;

    public Animal(String name, int price, String type, int age, boolean gender) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.age = age;
        this.gender = gender;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return type+"  "+name+" "+price+" "+age;
    }
}

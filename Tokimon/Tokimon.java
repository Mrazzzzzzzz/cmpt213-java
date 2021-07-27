package Documents.cmpt213.a1.Tokimon;

import java.util.Objects;

/**
 * Tokimon Class includes all the private attributes towards Tokimon and all the methods to edit the class attributes
 */
public class Tokimon {
    private String name;
    private String type;
    private double height;
    private double weight;
    private int strength;

    public Tokimon(String name, String type, double height, double weight) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
//        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "Name:'" + name + '\'' +
                ", Strength:" + strength +
                ", Height:" + height +
                ", Weight:" + weight +
                ", Ability:'" + type + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tokimon tokimon = (Tokimon) o;
        return Double.compare(tokimon.height, height) == 0 &&
                Double.compare(tokimon.weight, weight) == 0 &&
                strength == tokimon.strength &&
                name.equals(tokimon.name) &&
                type.equals(tokimon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, height, weight, strength);
    }

}

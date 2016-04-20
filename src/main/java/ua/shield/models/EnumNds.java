package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 */
public enum EnumNds {
    NONDS(0, "Без ПДВ"),
    NDS20(0.2, "З ПДВ");
    private final double factor;
    private final String description;

    EnumNds(double factor, String s) {
        this.factor = factor;
        this.description = s;
    }

    public double getFactor() {
        return this.factor;
    }

    public String getDescription() {
        return this.description;
    }
}

package pl.sda.design_patterns.duck.ducks;

public enum DuckType {
    MALLARD_DUCK(123D),
    GREEN_WINGED_TEAL_DUCK(12D),
    RUBBER_DUCK;

    Double yolkWeight;

    DuckType() {
    }

    DuckType(Double yolkWeight) {
        this.yolkWeight = yolkWeight;
    }

    public Double getYolkWeight() {
        return yolkWeight;
    }
}

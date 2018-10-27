package pl.sda.design_patterns.duck;

public class Fodder {
    private Integer cornGrams;
    private Integer wheatGrams;
    private Integer oatGrams;
    private Integer triticaleGrams;
    private Boolean minerals;
    private Boolean vitamins;

    public Integer getCornGrams() {
        return cornGrams;
    }

    public Integer getWheatGrams() {
        return wheatGrams;
    }

    public Integer getOatGrams() {
        return oatGrams;
    }

    public Integer getTriticaleGrams() {
        return triticaleGrams;
    }

    public Boolean getMinerals() {
        return minerals;
    }

    public Boolean getVitamins() {
        return vitamins;
    }

    public static class Builder {
        private Integer cornGrams;
        private Integer wheatGrams;
        private Integer oatGrams;
        private Integer triticaleGrams;
        private Boolean minerals;
        private Boolean vitamins;

    }
}

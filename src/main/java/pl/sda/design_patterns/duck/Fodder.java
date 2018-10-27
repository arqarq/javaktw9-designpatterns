package pl.sda.design_patterns.duck;

public class Fodder {
    private Integer cornGrams;
    private Integer wheatGrams;
    private Integer oatGrams;
    private Integer triticaleGrams;
    private Boolean minerals;
    private Boolean vitamins;

    //    private Fodder(final Builder builder) {
    private Fodder(Builder builder) {
        cornGrams = builder.cornGrams;
        wheatGrams = builder.wheatGrams;
        oatGrams = builder.oatGrams;
        triticaleGrams = builder.triticaleGrams;
        minerals = builder.minerals;
        vitamins = builder.vitamins;
    }

    public static Builder builder(Integer cornGrams, Integer wheatGrams) {
        if (cornGrams == null || cornGrams < 0) {
            throw new IllegalArgumentException("Corn must be provided");
        }
        if (wheatGrams == null || wheatGrams < 0) {
            throw new IllegalArgumentException("Wheat must be provided");
        }
        return new Builder(cornGrams, wheatGrams);
    }

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
        private final Integer cornGrams;
        private final Integer wheatGrams;
        private Integer oatGrams;
        private Integer triticaleGrams;
        private Boolean minerals;
        private Boolean vitamins;

        private Builder(Integer cornGrams, Integer wheatGrams) {
            this.cornGrams = cornGrams;
            this.wheatGrams = wheatGrams;
        }

        public Builder oatGrams(Integer oatGrams) {
            this.oatGrams = oatGrams;
            return this;
        }

        public Builder triticaleGrams(Integer triticaleGrams) {
            this.triticaleGrams = triticaleGrams;
            return this;
        }

        public Builder minerals(Boolean minerals) {
            this.minerals = minerals;
            return this;
        }

        public Builder vitamins(Boolean vitamins) {
            this.vitamins = vitamins;
            return this;
        }
        //setup all fields

        public Fodder build() {
            // if vitamins null wpisać domyślną
            return new Fodder(this); // konstruktor klasy Fodder
        }
    }
}

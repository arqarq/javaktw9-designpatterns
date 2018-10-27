package pl.sda.design_patterns.duck;

public class DuckEgg {
    private final Double yolkWeight;
    private final Double whiteWeight;
    private final Double totalWeight;

    private DuckEgg(Double yolkWeight, Double whiteWeight, Double totalWeight) {
        this.yolkWeight = yolkWeight;
        this.whiteWeight = whiteWeight;
        this.totalWeight = totalWeight;
    }

    public Double getYolkWeight() {
        return yolkWeight;
    }

    public Double getWhiteWeight() {
        return whiteWeight;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "DuckEgg{" +
                "yolkWeight=" + yolkWeight +
                ", whiteWeight=" + whiteWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }

    static class Builder {
        private Double yolkWeight; // startowo null

        void setYolkWeight(Double yolkWeight) {
            this.yolkWeight = yolkWeight; // ustawic mase zoltka w builderze
        }

        DuckEgg build() {
            Double calculatedYolk = yolkWeight != null ? yolkWeight : 0D;

            Double calculatedWhiteWeight = calculateWhiteWeight(calculatedYolk);

            Double calculatedMembraneWeight = calculateMembraneWeight(calculatedYolk, calculatedWhiteWeight);
            Double calculatedShellWeight = calculateShellWeight(calculatedWhiteWeight);

            Double totalWeight = calculatedYolk + calculatedWhiteWeight + calculatedMembraneWeight +
                    calculatedShellWeight;
            // logika tworzenie jajka
            return new DuckEgg(calculatedYolk, calculatedWhiteWeight, totalWeight);
        }

        private Double calculateShellWeight(Double calculatedWhiteWeight) {
            return Math.max(calculatedWhiteWeight * 0.07, 3D);
        }

        private Double calculateMembraneWeight(Double calculatedYolkWeight, Double whiteWeight) {
            return (calculatedYolkWeight + whiteWeight) * 0.005;
        }

        private Double calculateWhiteWeight(Double calculatedYolkWeight) {
//            return calculatedYolkWeight > 31.0 ? 1.2 * calculatedYolkWeight : 31.0;
            return Math.max(calculatedYolkWeight * 1.2, 31D);
        }
    }
}

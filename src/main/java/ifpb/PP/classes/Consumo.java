package ifpb.PP.classes;

import java.util.Random;

public class Consumo {
    private double taxa; // taxa máxima
    private Random random;

    public Consumo(double taxa) {
        this.taxa = taxa;
        this.random = new Random();
    }

    public double gerar() {
        return random.nextDouble() * taxa;
    }
}


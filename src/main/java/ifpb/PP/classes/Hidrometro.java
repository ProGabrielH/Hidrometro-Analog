package ifpb.PP.classes;

public class Hidrometro {
    private double leitura;
    private Consumo consumo;

    public Hidrometro(Consumo consumo) {
        this.leitura = 0.0;
        this.consumo = consumo;
    }

    public void registrar() {
        leitura += consumo.gerar();
    }

    public double getLeitura() {
        return leitura;
    }

    public void resetar() {
        leitura = 0.0;
    }
}

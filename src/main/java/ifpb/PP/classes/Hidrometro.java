package ifpb.PP.classes;

import java.util.ArrayList;
import java.util.List;

public class Hidrometro {
    private String numeroSerie;
    private double consumoTotal;
    private List<Consumo> historico;

    public Hidrometro(String numeroSerie){
        this.numeroSerie = numeroSerie;
        this.consumoTotal = 0;
        this.historico = new ArrayList<>();
    }

    public void registrarConsumo(double litros){
        consumoTotal += litros;
        historico.add(new Consumo(litros));
    }

    public void mostrarDisplayAnalogico(){
        int inteiro = (int) consumoTotal;
        int decimal = ((int) consumoTotal - inteiro);
        System.out.println("[" + inteiro + "," + decimal + "]");
    }

    public void mostrarHistorico(){
        for (Consumo c : historico) {
            System.out.println(c.getLitros() + " L em " + c.getDataHora());
        }
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }
}

package ifpb.PP;

import ifpb.PP.classes.Hidrometro;

public class Main {
    public static void main(String[] args) {
        Hidrometro h = new Hidrometro("HX-2025");
        h.registrarConsumo(2230.6);
        h.registrarConsumo(642.7);
        h.mostrarDisplayAnalogico();
        h.mostrarHistorico();
        System.out.println("Total: " + h.getConsumoTotal() + " L");
    }
}
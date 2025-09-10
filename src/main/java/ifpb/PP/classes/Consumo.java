package ifpb.PP.classes;

import java.time.LocalDateTime;

public class Consumo {

    private double litros;
    private LocalDateTime dataHora;

    public Consumo(double litros){
        this.litros = litros;
        this.dataHora = LocalDateTime.now();
    }

    public double getLitros() {
        return litros;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}

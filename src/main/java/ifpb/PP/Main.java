package ifpb.PP;

import ifpb.PP.display.TelaSimulador;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaSimulador tela = new TelaSimulador();
            tela.setVisible(true);
        });
    }
}
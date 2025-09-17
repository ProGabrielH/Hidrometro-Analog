package ifpb.PP.display;

import ifpb.PP.classes.Consumo;
import ifpb.PP.classes.Hidrometro;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class TelaSimulador extends JFrame {
    private PainelHidrometro painel;
    private ScheduledExecutorService executor;
    private Hidrometro hidrometro;

    public TelaSimulador() {
        setTitle("Simulador de Hidrômetro Analógico");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        Consumo consumo = new Consumo(0.2);
        hidrometro = new Hidrometro(consumo);

        painel = new PainelHidrometro();
        add(painel, BorderLayout.CENTER);


        JButton btnIniciar = new JButton("Iniciar");
        JButton btnPausar = new JButton("Pausar");
        JButton btnResetar = new JButton("Resetar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnIniciar);
        painelBotoes.add(btnPausar);
        painelBotoes.add(btnResetar);

        add(painelBotoes, BorderLayout.SOUTH);


        btnIniciar.addActionListener(e -> iniciarSimulacao());
        btnPausar.addActionListener(e -> pausarSimulacao());
        btnResetar.addActionListener(e -> resetarSimulacao());
    }

    private void iniciarSimulacao() {
        if (executor == null || executor.isShutdown()) {
            executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(() -> {
                hidrometro.registrar();
                painel.setLeitura(hidrometro.getLeitura());
            }, 0, 1, TimeUnit.SECONDS);
        }
    }

    private void pausarSimulacao() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
    }

    private void resetarSimulacao() {
        hidrometro.resetar();
        painel.setLeitura(hidrometro.getLeitura());
    }
}

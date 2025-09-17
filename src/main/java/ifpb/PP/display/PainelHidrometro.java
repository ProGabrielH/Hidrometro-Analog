package ifpb.PP.display;

import javax.swing.*;
import java.awt.*;

public class PainelHidrometro extends JPanel {
    private double leitura = 0.0;

    public void setLeitura(double leitura) {
        this.leitura = leitura;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int largura = getWidth();
        int altura = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cx = largura / 2;
        int cy = altura / 2;
        int raio = Math.min(largura, altura) / 3;

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, largura, altura);

        g2.setColor(Color.BLACK);
        g2.drawOval(cx - raio, cy - raio, 2 * raio, 2 * raio);

        for (int i = 0; i < 10; i++) {
            double angulo = Math.toRadians(i * 36 + 90);
            int x1 = cx + (int)(Math.cos(angulo) * (raio * 0.9));
            int y1 = cy + (int)(Math.sin(angulo) * (raio * 0.9));
            int x2 = cx + (int)(Math.cos(angulo) * raio);
            int y2 = cy + (int)(Math.sin(angulo) * raio);

            g2.drawLine(x1, y1, x2, y2);

            String texto = String.valueOf(i);
            int tx = cx + (int)(Math.cos(angulo) * (raio * 1.15)) - 5;
            int ty = cy + (int)(Math.sin(angulo) * (raio * 1.15)) + 5;
            g2.drawString(texto, tx, ty);
        }

        double angulo = Math.toRadians((leitura % 10) * 36 + 90);
        int x2 = cx + (int)(Math.cos(angulo) * raio * 0.8);
        int y2 = cy + (int)(Math.sin(angulo) * raio * 0.8);

        g2.setStroke(new BasicStroke(3));
        g2.drawLine(cx, cy, x2, y2);

        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString(String.format("Leitura: %.2f m³", leitura), cx - 60, cy + raio + 50);
    }
}

package Logica;

import javax.swing.*;
import java.awt.*;

public class PanelCarrusel_Ej {
    
        private CardLayout cardLayout;
    private JPanel cardPanel;

    public PanelCarrusel_Ej() {
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Agregar contenido
        cardPanel.add(crearPanel(Color.RED, "Imagen 1"), "1");
        cardPanel.add(crearPanel(Color.GREEN, "Imagen 2"), "2");
        cardPanel.add(crearPanel(Color.BLUE, "Imagen 3"), "3");

        JButton btnAnterior = new JButton("Anterior");
        JButton btnSiguiente = new JButton("Siguiente");

        btnAnterior.addActionListener(e -> cardLayout.previous(cardPanel));
        btnSiguiente.addActionListener(e -> cardLayout.next(cardPanel));

        JPanel controles = new JPanel();
        controles.add(btnAnterior);
        controles.add(btnSiguiente);

        add(cardPanel, BorderLayout.CENTER);
        add(controles, BorderLayout.SOUTH);
    }

    private JPanel crearPanel(Color color, String texto) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(texto));
        return panel;
    }

    private void add(JPanel cardPanel, String CENTER) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLayout(BorderLayout borderLayout) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    


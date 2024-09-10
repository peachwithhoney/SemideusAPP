package view;

import controller.LojaController;
import controller.MissaoController;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import model.Semideus;

public class PerfilSemideusView extends JFrame {
    private final Semideus semideus;
    private final LojaController lojaController;
    private final MissaoController missaoController;

    public PerfilSemideusView(Semideus semideus, LojaController lojaController, MissaoController missaoController) {
        this.semideus = semideus;
        this.lojaController = lojaController;
        this.missaoController = missaoController;
        setupUI();
    }

    private void setupUI() {
        setTitle("Perfil do Semideus: " + semideus.getUsername());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JLabel feriasLabel = new JLabel("Férias no Acampamento: " + semideus.getFeriasAcampamento());
        JLabel atosLabel = new JLabel("Atos Realizados: " + semideus.getAtosRealizados());

        panel.add(feriasLabel);
        panel.add(atosLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton lojaButton = new JButton("Ir para Loja");
        JButton missaoButton = new JButton("Ir para Missões");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(lojaButton);
        buttonPanel.add(missaoButton);

        panel.add(buttonPanel);

        lojaButton.addActionListener(e -> {
            LojaView lojaView = new LojaView(semideus, lojaController);
            lojaView.setVisible(true);
            lojaView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    
                    new PerfilSemideusView(semideus, lojaController, missaoController).setVisible(true);
                }
            });
            dispose();
        });

        missaoButton.addActionListener(e -> {
            MissaoView missaoView = new MissaoView(semideus, missaoController);
            missaoView.setVisible(true);
            missaoView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    
                    new PerfilSemideusView(semideus, lojaController, missaoController).setVisible(true);
                }
            });
            dispose();
        });

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> dispose());
        add(sairButton, BorderLayout.SOUTH);
    }
}

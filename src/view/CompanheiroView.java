package view;

import model.Semideus;
import model.Satiro;
import controller.MissaoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CompanheiroView extends JFrame {
    private final Semideus semideus;
    private final MissaoController missaoController;

    public CompanheiroView(Semideus semideus, MissaoController controller) {
        this.semideus = semideus;
        this.missaoController = controller;
        setupUI();
    }

    private void setupUI() {
        setTitle("Escolha seus Companheiros de Missão");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Selecione dois semideuses e um sátiro:");
        panel.add(label);

        JComboBox<String> semideus1Box = new JComboBox<>();
        JComboBox<String> semideus2Box = new JComboBox<>();
        JComboBox<String> satiroBox = new JComboBox<>();

        List<Semideus> semideuses = missaoController.getSemideusesDisponiveis();
        for (Semideus s : semideuses) {
            semideus1Box.addItem(s.getUsername());
            semideus2Box.addItem(s.getUsername());
        }

        List<Satiro> satiros = missaoController.getSatirosDisponiveis();
        for (Satiro s : satiros) {
            satiroBox.addItem(s.getNome());
        }

        panel.add(new JLabel("Semideus 1:"));
        panel.add(semideus1Box);
        panel.add(new JLabel("Semideus 2:"));
        panel.add(semideus2Box);
        panel.add(new JLabel("Sátiro:"));
        panel.add(satiroBox);

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String semideus1 = (String) semideus1Box.getSelectedItem();
                String semideus2 = (String) semideus2Box.getSelectedItem();
                String satiro = (String) satiroBox.getSelectedItem();

                missaoController.escolherCompanheiros(semideus, semideus1, semideus2, satiro);
            }
        });
        panel.add(confirmarButton);
    }
}

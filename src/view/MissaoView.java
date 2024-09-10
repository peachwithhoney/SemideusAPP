package view;

import controller.LojaController;
import controller.MissaoController;
import dao.ItemDAO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;
import model.Missao;
import model.Semideus;

public class MissaoView extends JFrame {
    private final Semideus semideus;
    private final MissaoController missaoController;
    private final JPanel missaoPanel;

    public MissaoView(Semideus semideus, MissaoController missaoController) {
        this.semideus = semideus;
        this.missaoController = missaoController;
        this.missaoPanel = new JPanel();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Missões de " + semideus.getUsername());
        setSize(400, 300);
        setLayout(new BorderLayout());

        missaoPanel.setLayout(new BoxLayout(missaoPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(missaoPanel);

        carregarMissoes();

        add(scrollPane, BorderLayout.CENTER);

        JButton addMissaoButton = new JButton("Adicionar Missão");
        addMissaoButton.addActionListener(e -> adicionarMissao());
        add(addMissaoButton, BorderLayout.SOUTH);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> {
            this.dispose();
            voltarParaPerfil();
        });
        add(sairButton, BorderLayout.NORTH);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                voltarParaPerfil();
            }
        });
    }

    private void carregarMissoes() {
        missaoPanel.removeAll();
        List<Missao> missoes = missaoController.getMissoesAssociadas(semideus);

        for (Missao missao : missoes) {
            JLabel missaoLabel = new JLabel(missao.getDescricao());
            missaoPanel.add(missaoLabel);
        }

        missaoPanel.revalidate();
        missaoPanel.repaint();
    }

    private void adicionarMissao() {
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição da missão:");
        if (descricao != null && !descricao.isEmpty()) {
            missaoController.adicionarMissao(semideus, descricao);
            JOptionPane.showMessageDialog(this, "Missão adicionada com sucesso!");
            carregarMissoes();
        }
    }

    private void voltarParaPerfil() {
    ItemDAO itemDAO = new ItemDAO();
    new PerfilSemideusView(semideus, new LojaController(itemDAO), missaoController).setVisible(true);
}

}

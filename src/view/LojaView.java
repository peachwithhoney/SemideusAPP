package view;

import controller.LojaController;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Item;
import model.Semideus;

public class LojaView extends JFrame {
    private final Semideus semideus;
    private final LojaController lojaController;

    public LojaView(Semideus semideus, LojaController lojaController) {
        this.semideus = semideus;
        this.lojaController = lojaController;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Loja de Itens");
        setSize(400, 300);
        setLayout(new BorderLayout());

        
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(itemPanel);

        List<Item> itensDisponiveis = lojaController.getItensDisponiveis();

        
        for (Item item : itensDisponiveis) {
            JPanel itemLine = new JPanel();
            itemLine.setLayout(new FlowLayout());

            JLabel itemLabel = new JLabel(item.getNome() + " - Preço: " + item.getPreco() + " dracmas");
            JButton comprarButton = new JButton("Comprar");

            
            comprarButton.addActionListener(e -> {
                if (semideus.getDracmas() >= item.getPreco()) {
                    lojaController.comprarItem(semideus, item);
                    JOptionPane.showMessageDialog(this, "Item comprado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Você não tem dracmas suficientes para comprar este item.");
                }
            });

            itemLine.add(itemLabel);
            itemLine.add(comprarButton);
            itemPanel.add(itemLine);
        }

        
        JLabel saldoLabel = new JLabel("Saldo atual: " + semideus.getDracmas() + " dracmas");
        add(saldoLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> dispose());
        add(sairButton, BorderLayout.SOUTH);
    }
}

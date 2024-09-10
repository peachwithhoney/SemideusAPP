package main;

import controller.LoginController;
import dao.SemideusDAO;
import facade.SemideusFacade;
import javax.swing.*;
import model.Missao;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        SemideusFacade facade = new SemideusFacade();

        SemideusDAO semideusDAO = new SemideusDAO();
        semideusDAO.carregarSemideuses();

        LoginView loginView = new LoginView(null);
        LoginController loginController = new LoginController(loginView, semideusDAO);
        loginView = new LoginView(loginController);
        loginView.setVisible(true);

        loginController.addLoginSuccessListener(semideus -> {
            
            facade.exibirPerfil(semideus);

            
            JButton lojaButton = new JButton("Ir para Loja");
            lojaButton.addActionListener(e -> facade.exibirLoja(semideus));

            
            JButton missaoButton = new JButton("Ver Missões");
            missaoButton.addActionListener(e -> facade.exibirMissoes(semideus));

            Missao missao = facade.getMissoesDisponiveis().get(0); 
            JButton iniciarMissaoButton = new JButton("Iniciar Missão");
            iniciarMissaoButton.addActionListener(e -> facade.iniciarMissao(semideus, missao));
        });
    }
}

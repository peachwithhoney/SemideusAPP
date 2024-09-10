package view;

import controller.LoginController;
import javax.swing.*;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private final LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
        setupUI();
    }

    private void setupUI() {
        setTitle("Login Semideus");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        loginButton.addActionListener(e -> controller.login(usernameField.getText(), new String(passwordField.getPassword())));
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 10, 160, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 40, 160, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 250, 25);
        panel.add(loginButton);
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
    }
}

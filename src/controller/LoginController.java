package controller;

import dao.SemideusDAO;
import java.util.ArrayList;
import java.util.List;
import model.Semideus;
import view.LoginView;

public class LoginController {
    private final LoginView view;
    private final SemideusDAO semideusDAO;
    private final List<LoginSuccessListener> loginSuccessListeners = new ArrayList<>();

    public LoginController(LoginView view, SemideusDAO semideusDAO) {
        this.view = view;
        this.semideusDAO = semideusDAO;
    }

    public void addLoginSuccessListener(LoginSuccessListener listener) {
        loginSuccessListeners.add(listener);
    }

    public void login(String username, String password) {
        Semideus semideus = semideusDAO.getSemideusByUsername(username);
        if (semideus != null && semideus.getPassword().equals(password)) {
            view.showSuccessMessage();

            for (LoginSuccessListener listener : loginSuccessListeners) {
                listener.onLoginSuccess(semideus);
            }

            exibirPerfil(semideus);
        } else {
            view.showErrorMessage();
        }
    }

    private void exibirPerfil(Semideus semideus) {

    }
}

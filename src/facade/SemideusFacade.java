package facade;

import controller.LojaController;
import controller.MissaoController;
import dao.ItemDAO;
import dao.MissaoDAO;
import dao.SatiroDAO;
import dao.SemideusDAO;
import java.util.List;
import model.Item;
import model.Missao;
import model.Semideus;
import view.LojaView;
import view.MissaoView;
import view.PerfilSemideusView;

public class SemideusFacade {
    private final SemideusDAO semideusDAO;
    private final MissaoController missaoController;
    private final LojaController lojaController;

    public SemideusFacade() {
        semideusDAO = new SemideusDAO();
        semideusDAO.carregarSemideuses();

        MissaoDAO missaoDAO = new MissaoDAO();
        missaoDAO.carregarMissoes();
        SatiroDAO satiroDAO = new SatiroDAO();
        
        missaoController = new MissaoController(missaoDAO, satiroDAO, semideusDAO);
        ItemDAO itemDAO = new ItemDAO();
        lojaController = new LojaController(itemDAO);
    }

    public void exibirPerfil(Semideus semideus) {
        PerfilSemideusView perfilView = new PerfilSemideusView(semideus, lojaController, missaoController);
        perfilView.setVisible(true);
    }

    public void exibirLoja(Semideus semideus) {
        LojaView lojaView = new LojaView(semideus, lojaController);
        lojaView.setVisible(true);
    }

    public void comprarItem(Semideus semideus, Item item) {
        lojaController.comprarItem(semideus, item);
    }

    public void exibirMissoes(Semideus semideus) {
        MissaoView missaoView = new MissaoView(semideus, missaoController);
        missaoView.setVisible(true);
    }

    public void iniciarMissao(Semideus semideus, Missao missao) {
        missaoController.iniciarMissao(semideus, missao);
    }

    public List<Missao> getMissoesDisponiveis() {
        return missaoController.getMissoesDisponiveis();
    }

    public List<Missao> getMissoesAssociadas(Semideus semideus) {
        return missaoController.getMissoesAssociadas(semideus);
    }

    public void adicionarMissao(Semideus semideus, String descricao) {
        missaoController.adicionarMissao(semideus, descricao);
    }
}

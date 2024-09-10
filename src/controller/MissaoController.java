package controller;

import dao.MissaoDAO;
import dao.SatiroDAO;
import dao.SemideusDAO;
import java.util.Date;
import java.util.List;
import model.Missao;
import model.Satiro;
import model.Semideus;

public class MissaoController {
    private final MissaoDAO missaoDAO;
    private final SatiroDAO satiroDAO;
    private final SemideusDAO semideusDAO;

    public MissaoController(MissaoDAO missaoDAO, SatiroDAO satiroDAO, SemideusDAO semideusDAO) {
        this.missaoDAO = missaoDAO;
        this.satiroDAO = satiroDAO;
        this.semideusDAO = semideusDAO;
    }

    public List<Missao> getMissoesDisponiveis() {
        return missaoDAO.getMissoesDisponiveis();
    }
    
    public void iniciarMissao(Semideus semideus, Missao missao) {
        if (semideus.getDracmas() >= 200) {
            semideus.subtractDracmas(200);
            missao.completarMissao();
            semideus.addDracmas(missao.getRecompensaDracmas());
            semideus.incrementarAtos();
    
            missaoDAO.salvarMissoes();
            semideusDAO.salvarSemideuses();
        }
    }

    public void escolherCompanheiros(Semideus semideus, String semideus1, String semideus2, String satiro) {
        System.out.println("Companheiros selecionados: " + semideus1 + ", " + semideus2 + ", Sátiro: " + satiro);
    }

    public List<Semideus> getSemideusesDisponiveis() {
        return semideusDAO.getSemideuses(); 
    }

    public List<Satiro> getSatirosDisponiveis() {
        return satiroDAO.getSatirosDisponiveis();
    }
    
    public List<Missao> getMissoesAssociadas(Semideus semideus) {
        return semideus.getMissoes();
    }

    
    public void adicionarMissao(Semideus semideus, String descricao) {
        String nomeMissao = "Nome da Missão";  
        Date dataInicio = new Date();  
        int recompensaDracmas = 100;  
        
        Missao novaMissao = new Missao(nomeMissao, descricao, dataInicio, recompensaDracmas);
        
        missaoDAO.adicionarMissao(novaMissao);
        semideus.addMissao(novaMissao);
        semideusDAO.salvarSemideuses();
    }
}

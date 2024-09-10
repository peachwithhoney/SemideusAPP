package model;

import java.util.ArrayList;
import java.util.List;

public class Semideus {
    private String username;
    private String password;
    private String chale;
    private int anoNascimento;
    private int dracmas;
    private int feriasAcampamento;
    private int atosRealizados;  
    private final List<Item> itens;
    private final List<Missao> missoes;

    
    public Semideus(String username, String password, String chale, int anoNascimento) {
        this.username = username;
        this.password = password;
        this.chale = chale;
        this.anoNascimento = anoNascimento;
        this.dracmas = 200; 
        this.feriasAcampamento = 0;
        this.atosRealizados = 0;
        this.itens = new ArrayList<>(); 
        this.missoes = new ArrayList<>();
    }
    
    public void addMissao(Missao missao) {
        this.missoes.add(missao);
    }

    public List<Missao> getMissoes() {
        return this.missoes;
    }

    public List<Item> getItens() {
        return itens;
    }
    
    public void incrementarAtos() {
        this.atosRealizados++;
    }

    public void incrementarFerias() {
        this.feriasAcampamento++;
    }

    public void addDracmas(int quantidade) {
        this.dracmas += quantidade;
    }

    public void subtractDracmas(int quantidade) {
        if (this.dracmas >= quantidade) {
            this.dracmas -= quantidade;
        } else {
            System.out.println("Você não tem dracmas suficientes.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChale() {
        return chale;
    }

    public void setChale(String chale) {
        this.chale = chale;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getDracmas() {
        return dracmas;
    }

    public void setDracmas(int dracmas) {
        this.dracmas = dracmas;
    }

    public int getFeriasAcampamento() {
        return feriasAcampamento;
    }

    public int getAtosRealizados() {
        return atosRealizados;
    }
}

package model;

import java.util.Date;
import java.util.List;

public class Missao {
    private final String nome;
    private final String descricao;
    private final Date dataLimite;
    private List<String> companheiros;
    private final int recompensaDracmas;
    private boolean completa;

    public Missao(String nome, String descricao, Date dataLimite, int recompensaDracmas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.recompensaDracmas = recompensaDracmas;
        this.completa = false;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Date getDataLimite() { return dataLimite; }
    public int getRecompensaDracmas() { return recompensaDracmas; }
    public boolean isCompleta() { return completa; }

    public void completarMissao() { this.completa = true; }
    public void setCompanheiros(List<String> companheiros) { this.companheiros = companheiros; }
    public List<String> getCompanheiros() { return companheiros; }
}

package model;

public class Item {
    private final String nome;
    private final int preco;

    public Item(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public int getPreco() { return preco; }
}

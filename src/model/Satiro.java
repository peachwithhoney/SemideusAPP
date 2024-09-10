package model;

public class Satiro {
    private final String nome;
    private final int forca;

    
    public Satiro(String nome, int forca) {
        this.nome = nome;
        this.forca = forca;
    }

   
    public String getNome() { 
        return nome; 
    }

    public int getForca() { 
        return forca; 
    }
}

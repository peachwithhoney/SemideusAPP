package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Satiro;

public class SatiroDAO {
    private final List<Satiro> satiros;
    private static final String FILENAME = "resources/satiros.txt"; 

    public SatiroDAO() {
        satiros = new ArrayList<>();
    }

    public void carregarSatiros() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nome = partes[0];
                    int nivel = Integer.parseInt(partes[1]);
                    Satiro satiro = new Satiro(nome, nivel);
                    satiros.add(satiro);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os sátiros: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Arquivo de sátiros não encontrado: " + FILENAME);
        }
    }

    public void salvarSatiros() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + FILENAME))) {
            for (Satiro satiro : satiros) {
                writer.write(satiro.getNome() + "," + satiro.getForca());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os sátiros: " + e.getMessage());
        }
    }

    public List<Satiro> getSatirosDisponiveis() {
        return satiros;
    }

    public void adicionarSatiro(Satiro satiro) {
        satiros.add(satiro);
        salvarSatiros(); 
    }
}

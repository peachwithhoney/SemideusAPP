package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Semideus;

public class SemideusDAO {
    private final List<Semideus> semideuses;
    private static final String FILENAME = "resources/semideuses.txt";  

    public SemideusDAO() {
        semideuses = new ArrayList<>();
    }

    
    public void carregarSemideuses() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 7) {
                    String username = partes[0];
                    String password = partes[1];
                    String chale = partes[2];
                    int anoNascimento = Integer.parseInt(partes[3]);
                    int dracmas = Integer.parseInt(partes[4]);
                    int ferias = Integer.parseInt(partes[5]);
                    int atos = Integer.parseInt(partes[6]);

                    Semideus semideus = new Semideus(username, password, chale, anoNascimento);
                    semideus.addDracmas(dracmas - 200);  
                    for (int i = 0; i < ferias; i++) {
                        semideus.incrementarFerias();
                    }
                    for (int i = 0; i < atos; i++) {
                        semideus.incrementarAtos();
                    }
                    semideuses.add(semideus);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os semideuses: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Arquivo de semideuses não encontrado: " + FILENAME);
        }
    }

    
    public void salvarSemideuses() {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + FILENAME))) {
            for (Semideus semideus : semideuses) {
                writer.write(semideus.getUsername() + "," + semideus.getPassword() + "," + semideus.getChale() + "," +
                        semideus.getAnoNascimento() + "," + semideus.getDracmas() + "," +
                        semideus.getFeriasAcampamento() + "," + semideus.getAtosRealizados());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os semideuses: " + e.getMessage());
        }
    }

    
    public void adicionarSemideus(Semideus semideus) {
        semideuses.add(semideus);
        salvarSemideuses();  
    }

    public Semideus getSemideusByUsername(String username) {
        for (Semideus s : semideuses) {
            if (s.getUsername().equals(username)) {
                return s;
            }
        }
        return null;
    }

    public List<Semideus> getSemideuses() {
        return semideuses;
    }
}

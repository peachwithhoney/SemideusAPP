package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Missao;

public class MissaoDAO {
    private final List<Missao> missoesDisponiveis;
    private static final String FILENAME = "resources/missoes.txt";

    public MissaoDAO() {
        missoesDisponiveis = new ArrayList<>();
    }

    
    public void carregarMissoes() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    String nome = partes[0];
                    String descricao = partes[1];
                    int recompensaDracmas = Integer.parseInt(partes[2]);
                    boolean completa = Boolean.parseBoolean(partes[3]);

                    Missao missao = new Missao(nome, descricao, null, recompensaDracmas);
                    if (completa) {
                        missao.completarMissao();
                    }
                    missoesDisponiveis.add(missao);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar as missões: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Arquivo de missões não encontrado: " + FILENAME);
        }
    }

    
    public void salvarMissoes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + FILENAME))) {
            for (Missao missao : missoesDisponiveis) {
                writer.write(missao.getNome() + "," + missao.getDescricao() + "," + missao.getRecompensaDracmas() + "," + missao.isCompleta());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar as missões: " + e.getMessage());
        }
    }

    
    public List<Missao> getMissoesDisponiveis() {
        return missoesDisponiveis;
    }

    
    public void adicionarMissao(Missao missao) {
        missoesDisponiveis.add(missao);
        salvarMissoes(); 
    }
}

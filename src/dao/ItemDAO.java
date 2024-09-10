package dao;

import java.util.ArrayList;
import java.util.List;
import model.Item;

public class ItemDAO {
    private final List<Item> itensDisponiveis;

    public ItemDAO() {
        itensDisponiveis = new ArrayList<>();
        
        itensDisponiveis.add(new Item("Espada de Bronze Celestial", 150));
        itensDisponiveis.add(new Item("Escudo de Aegis", 300));
        itensDisponiveis.add(new Item("Elmo de Invisibilidade", 500));
    }

    public List<Item> getItensDisponiveis() {
        return itensDisponiveis;
    }
}

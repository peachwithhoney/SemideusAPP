package controller;

import dao.ItemDAO;
import model.Item;
import model.Semideus;

public class LojaController {
    private final ItemDAO itemDAO;

    public LojaController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public java.util.List<Item> getItensDisponiveis() {
        return itemDAO.getItensDisponiveis();
    }

    public void comprarItem(Semideus semideus, Item item) {
        if (semideus.getDracmas() >= item.getPreco()) {
            semideus.subtractDracmas(item.getPreco());
            semideus.getItens().add(item);
        }
    }
}

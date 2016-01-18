package br.com.rmsystems.mytruffles.repositorys;

import java.util.ArrayList;
import java.util.List;

import br.com.rmsystems.mytruffles.models.Truffle;

public class TruffleRepository {

    private static class Singleton {
        public static final TruffleRepository INSTANCE = new TruffleRepository();
    }

    private TruffleRepository() {
        super();
    }

    public static TruffleRepository getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Truffle> getAll() {
        List<Truffle> list = new ArrayList<>();

        list.add(this.setAll(1, "Mousse de Morango", 2.50));
        list.add(this.setAll(2, "Mousse de Abacaxi", 2.50));
        list.add(this.setAll(3, "Mousse de Limão", 2.50));
        list.add(this.setAll(4, "Doce de Leite", 2.50));
        list.add(this.setAll(5, "Floresta Negra", 3.00));
        list.add(this.setAll(6, "Brigadeiro", 3.00));
        list.add(this.setAll(7, "Mousse de Maracujá", 2.50));
        list.add(this.setAll(8, "Leite Ninho", 3.00));
        list.add(this.setAll(9, "Leite Condensado", 3.00));

        return list;
    }

    public Truffle setAll(Integer id, String flavor, double value) {
        Truffle truffle = new Truffle();
        truffle.setId(id);
        truffle.setFlavor(flavor);
        truffle.setValue(value);

        return truffle;
    }

}

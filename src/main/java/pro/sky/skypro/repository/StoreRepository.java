package pro.sky.skypro.repository;

import org.springframework.stereotype.Repository;
import pro.sky.skypro.model.Item;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreRepository {
    private int idCouter = 1;
    private final Map<Integer, Item> store = new HashMap<>();

@PostConstruct
    public void init() {
        store.put(idCouter, new Item(idCouter++, "груша"));
        store.put(idCouter, new Item(idCouter++, "яблоко"));
        store.put(idCouter, new Item(idCouter++, "апельсин"));

    }

    public void add(Item item) {
        store.put(item.getId(), item);
    }

    public Item get(int id) {
        return store.get(id);
    }

    public List<Item> getAll() {
        return new ArrayList<>(store.values());
    }

    public void update(int id, Item item) {
        if (store.containsKey(id)) {
            store.replace(id, item);
        }
    }

    public Item delete(int id) {
        return store.remove(id);

    }
}

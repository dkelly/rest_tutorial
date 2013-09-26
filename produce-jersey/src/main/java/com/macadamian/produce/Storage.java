package com.macadamian.produce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static Storage _instance;

    public static Storage instance() {
        if (null == _instance) {
            _instance = new Storage();
        }
        return _instance;
    }

    private HashMap<Integer, Fruit> _fruits = new HashMap<Integer, Fruit>();
    private HashMap<Integer, Purchase> _purchases = new HashMap<Integer, Purchase>();

    private Storage() {
        Fruit f = new Fruit() {{ id = 1; type = "apple"; quantity = 12; price = 1.25; }};
        _fruits.put(f.id, f);
        f = new Fruit() {{ id = 2; type = "pear"; quantity = 8; price = 1.00; }};
        _fruits.put(f.id, f);
        f = new Fruit() {{ id = 3; type = "apricot"; quantity = 15; price = 1.50; }};
        _fruits.put(f.id, f);
    }
    
    public List<Fruit> allFruits() {
        List<Fruit> rv = new ArrayList<Fruit>();
        rv.addAll(_fruits.values());
        return rv;
    }

    public Fruit getFruit(int id) {
        Fruit rv = null;
        if (_fruits.containsKey(id)) {
            rv = _fruits.get(id);
        }
        return rv;
    }

    public Fruit removeFruit(int id) {
        Fruit rv = getFruit(id);
        if (null != rv) {
            _fruits.remove(rv.id);
        }
        return rv;
    }
    
    public void addFruit(Fruit f) {
        f.id = _fruits.size() + 1;
        _fruits.put(f.id, f);
    }

    public void updateFruit(int id, Fruit f) {
        if (_fruits.containsKey(id)) {
            Fruit stored = _fruits.get(id);
            stored.type = f.type;
            stored.quantity = f.quantity;
            stored.price = f.price;
        }
    }

    public List<Purchase> allPurchases() {
        List<Purchase> rv = new ArrayList<Purchase>();
        rv.addAll(_purchases.values());
        return rv;
    }

    public void addPurchase(final Purchase p) {
        try {
            Purchase added = new Purchase() {{ id = _purchases.size() + 1; fruit_id = p.fruit_id; quantity = p.quantity; }};
            Fruit f = _fruits.get(p.fruit_id);
            f.quantity -= p.quantity;
            _fruits.put(f.id, f);
            _purchases.put(added.id, added);
            
        } catch (Exception e) {
        }
    }
}

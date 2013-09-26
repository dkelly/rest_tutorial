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
}

package com.mutaki.hexadraw.io;

import java.util.ArrayList;
import java.util.List;

public class Saveables {

    private final List<Saveable> saveables = new ArrayList<>();

    public void add(Saveable saveable) {
	saveables.add(saveable);
    }

    public void save() {
	saveables.forEach(Saveable::save);
    }

}

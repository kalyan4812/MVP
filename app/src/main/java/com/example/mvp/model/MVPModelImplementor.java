package com.example.mvp.model;

import java.util.ArrayList;
import java.util.List;

public class MVPModelImplementor implements MVPModel {
    ModelAdapter modelAdapter;
    List<String> names;


    public MVPModelImplementor(ModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
        this.names = modelAdapter.getAllToDos();

    }


    @Override
    public List<String> getlist() {
        return names;
    }

    @Override
    public void addItem(String s) {
        modelAdapter.addItem(s);

    }
}

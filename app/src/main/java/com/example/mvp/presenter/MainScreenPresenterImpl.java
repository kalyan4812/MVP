package com.example.mvp.presenter;

import com.example.mvp.MainScreenContract;
import com.example.mvp.model.MVPModel;
import com.example.mvp.model.MVPModelImplementor;
import com.example.mvp.model.ModelAdapter;

public class MainScreenPresenterImpl implements MainScreenContract.Presentor {
    MainScreenContract.View view;
    MVPModel mvpModel;
    public MainScreenPresenterImpl(MainScreenContract.View view){
        this.view=view;
        mvpModel=new MVPModelImplementor(new ModelAdapter());
        this.view.setPresentor(this);
    }
    @Override
    public void onAddButtonClicked(String s) {
      mvpModel.addItem(s);
      view.showitems(mvpModel.getlist());
    }

    @Override
    public void start() {
     view.showitems(mvpModel.getlist());
    }
}

package com.example.mvp;

import com.example.mvp.BasePresentor;
import com.example.mvp.BaseView;

import java.util.List;

public interface MainScreenContract {
    interface View extends BaseView<Presentor> {
        public void showitems(List<String> strings);
    }

    interface Presentor extends BasePresentor {
        public void onAddButtonClicked(String s);
    }
}

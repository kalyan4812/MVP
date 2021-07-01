package com.example.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mvp.MainScreenContract;
import com.example.mvp.R;
import com.example.mvp.presenter.MainScreenPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {
    MainScreenContract.Presentor presentor;
    EditText editText;
    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentor = new MainScreenPresenterImpl(this);
        listView = findViewById(R.id.listview);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentor.onAddButtonClicked(editText.getText().toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presentor.start();
    }

    @Override
    public void showitems(List<String> strings) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, strings);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    public void setPresentor(MainScreenContract.Presentor presentor) {
        this.presentor = presentor;
    }
}

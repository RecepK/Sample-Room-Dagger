package com.rkurban.sample_room_dagger2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rkurban.sample_room_dagger2.R;
import com.rkurban.sample_room_dagger2.modules.main.MainView;
import com.rkurban.sample_room_dagger2.modules.main.Presenter;
import com.rkurban.sample_room_dagger2.modules.room.AppDatabase;
import com.rkurban.sample_room_dagger2.modules.room.Model;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, View.OnLongClickListener {

    @Inject
    Presenter presenter;

    private EditText editText;
    private Button button;
    private TextView textView;

    private List<Model> list;

    @Inject
    AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);

        presenter.init();

        //AppDatabase
        //appDatabase = AppDatabase.getDatabase(this.getApplication());


        getList();
    }

    private void getList() {
        list = appDatabase.modelDao().getList();
        if (list.size() < 1)
            Log.d("RKRK", "size <1");


        if (list.size() > 0) {

            String s = "";

            for (Model model : list) {
                Log.d("RKRK", "name: " + model.getName());
                s += model.getId() + " " + model.getName() + "\n";
            }

            textView.setText(s);
        }
    }

    public void showMessage(String msg) {
        Log.d("RKRK", msg);
    }

    @Override
    public void onClick(View v) {
        String s = editText.getText().toString();
        if (!s.isEmpty())
            appDatabase.modelDao().addModel(new Model(s));

        //getList
        getList();
    }

    @Override
    public boolean onLongClick(View v) {
        if (list.size() > 0)
            appDatabase.modelDao().deleteModel(list.get(0));
        return false;
    }
}

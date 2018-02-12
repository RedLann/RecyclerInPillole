package me.vdipalma.enzo.recyclerinpillole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomAdapter.RubricaItemClickedListener {
    ArrayList<OggettoStupido> oggetti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oggetti = new ArrayList<>();
        for ( int i = 0; i < 10; i++){
            oggetti.add(new OggettoStupido("nome"+i, "cognome"+i, Long.parseLong(""+i)));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CustomAdapter customAdapter = new CustomAdapter(this, oggetti);
        recyclerView.setAdapter(customAdapter);

        Button add_more = findViewById(R.id.add_more);
        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++){
                    oggetti.add(new OggettoStupido("added nome"+1, "added cognome"+i, Long.parseLong(""+i)));
                }
                customAdapter.notifyDataSetChanged(); // questo ricarica la view, meglio usare i notify piu specifici se fai spesso modifiche
            }
        });

    }

    @Override
    public void itemClicked(OggettoStupido oggettoStupido) {

    }
}

package com.ews.demorecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.ews.demorecyclerview.adapter.LivroAdapter;
import com.ews.demorecyclerview.adapter.OnItemClickListener;
import com.ews.demorecyclerview.api.LivroAPI;
import com.ews.demorecyclerview.model.LayoutManagerType;
import com.ews.demorecyclerview.model.Livro;


public class LayoutManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public static final String TAG_LOG = "LayoutManagerActivity";

    public static final String PUT_LIVRO = "com.ews.demorecyclerview.LIVRO";

    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(Livro livro) {
            Log.d(TAG_LOG, livro.toString());
            //Toast.makeText(getApplicationContext(), livro.getNomeLivro(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LayoutManagerActivity.this, LayoutDetalheActivity.class);
            intent.putExtra(PUT_LIVRO, livro);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_manager);

        //----------------------------------------------------------------------------------------//
        this.recyclerView = (RecyclerView) findViewById(R.id.livroRecyclerView);

        LayoutManagerType serializableExtra = (LayoutManagerType)
                getIntent().getSerializableExtra(LayoutManagerType.Layout.name());

        switch (serializableExtra) {

            case LinearLayoutManager:
                layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                break;

            case GridLayoutManager :
                layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
                break;

            case StaggeredGridLayoutManager :
                layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                break;
        }

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(new LivroAdapter(LivroAPI.livros(), listener));
        //----------------------------------------------------------------------------------------//
    }
}

package com.ews.demorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ews.demorecyclerview.model.Livro;

public class LayoutDetalheActivity extends AppCompatActivity {

    private TextView dtNomeLivro, dtNomeAutor, dtDescricao, dtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_detalhe);

        this.dtNomeLivro = (TextView) findViewById(R.id.dtDescricao);
        this.dtNomeAutor = (TextView) findViewById(R.id.dtNomeAutor);
        this.dtDescricao = (TextView) findViewById(R.id.dtDescricao);
        this.dtPreco = (TextView) findViewById(R.id.dtPreco);

        Livro livro = (Livro) getIntent().getSerializableExtra(LayoutManagerActivity.PUT_LIVRO);
        if (livro != null) {
            this.dtNomeLivro.setText(livro.getNomeLivro());
            this.dtNomeAutor.setText(livro.getNomeAutor());
            this.dtDescricao.setText(livro.getDescricao());
            this.dtPreco.setText("R$ " + livro.getPreco());
        }

    }
}

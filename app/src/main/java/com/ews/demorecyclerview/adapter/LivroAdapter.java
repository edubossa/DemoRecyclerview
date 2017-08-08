package com.ews.demorecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ews.demorecyclerview.R;
import com.ews.demorecyclerview.model.Livro;

import java.util.List;

/**
 * Created by wallace on 26/06/17.
 */
public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroViewHolder> {

    private List<Livro> livros;
    private OnItemClickListener onItemClickListener;

    public LivroAdapter(List<Livro> livros, OnItemClickListener onItemClickListener) {
        this.livros = livros;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public LivroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livro, parent, false);
        return new LivroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivroViewHolder holder, int position) {
        final Livro livro = this.livros.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(livro);
            }
        });

        holder.nomeLivro.setText(livro.getNomeLivro());
        holder.nomeAutor.setText(livro.getDescricao());
        holder.descricao.setText(livro.getDescricao());
        holder.preco.setText(livro.getPreco().toString());
    }

    @Override
    public int getItemCount() {
        return this.livros.size();
    }


    static class LivroViewHolder extends RecyclerView.ViewHolder {

        final TextView nomeLivro;
        final TextView nomeAutor;
        final TextView descricao;
        final TextView preco;

        public LivroViewHolder(View itemView) {
            super(itemView);
            this.nomeLivro = (TextView) itemView.findViewById(R.id.nomeLivro);
            this.nomeAutor = (TextView) itemView.findViewById(R.id.nomeAutor);
            this.descricao = (TextView) itemView.findViewById(R.id.descricao);
            this.preco = (TextView) itemView.findViewById(R.id.preco);
        }
    }

}

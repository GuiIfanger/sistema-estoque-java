package org.example.model;

import java.util.List;
import java.util.ArrayList;

public class Estoque {

    private List<Produto> produtos=  new ArrayList<>();

    public void addProduto(Produto produto){
        produtos.add(produto);
    }

    public void ListarProdutos(){
        for(Produto produto : produtos){
            produto.exibirDetalhes();
        }
    }

    public void excluirProduto(int id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto buscaID(int id){
        for(Produto produto : produtos){
            if(produto.getId() == id){
                return produto;
            }
        }
        return null;
    }
}

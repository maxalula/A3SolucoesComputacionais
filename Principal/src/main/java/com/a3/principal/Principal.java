package com.a3.principal;

import java.util.*;

public class Principal
{
    static ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();
    public static void main(String[] args)
    {
        InitializeProducts();
        System.out.println(produtosEmEstoque.get(0).toString());
    }
    
    public static void InitializeProducts()
    {
        produtosEmEstoque.add(new ProdutoBuilder().setId(1).getProduto());
        /*produtosEmEstoque.add(new Produto());
        produtosEmEstoque.add(new Produto());
        produtosEmEstoque.add(new Produto());
        produtosEmEstoque.add(new Produto());
        produtosEmEstoque.add(new Produto());
        produtosEmEstoque.add(new Produto());*/
    }
}
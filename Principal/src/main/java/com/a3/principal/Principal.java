/*
DESCRIÇÃO COMPLETA DA EQUIPE
INTEGRANTES:
{
    Nome: Rafael Dos Anjos Costa 
    RA: 1272419765
}
{
    Nome: Gabriel Enzo Coutinho de Melo 
    RA: 1272412136
}
{
    Nome: Eduardo Batista Araujo  
    RA: 1272327420
}
{
    Nome: Tiago Silva Coelho Maciel
    RA: 1272326567
}
{
    Nome: Marcossuel 
    RA: 
}
*/
package com.a3.principal;

import java.util.*;

public class Principal
{
    public static void main(String[] args)
    {
        InicializarSeteProdutos();
        
        
        //Listar estoque
        for(int i=0;i<Estoque.ObterEstoque().QuantidadeProdutosEstoque();i++)
        {
            System.out.println(Estoque.ObterEstoque().ObterProdutoNoIndice(i));
        }
        
        PrintEmptyLine();
        
        //Listar por ID - Ordem Crescente(Atributo da classe Produto)
        
        Produto[] produtosOrdenados = Estoque.ObterEstoque().ObterEstoquePor(AtributosProduto.AVAILABLE_AMOUNT, true, "int");
        
        for(int i=0;i<produtosOrdenados.length;i++)
        {
            System.out.println(produtosOrdenados[i]);
        }
        
        PrintEmptyLine();
        
        //Buscar produtos por nome;
        String buscaFeita = "a";
        ArrayList<Produto> produtosEncontrados = Estoque.ObterEstoque().BuscarProdutoPor(AtributosProduto.NAME, buscaFeita);
        
        for(int i=0; i<produtosEncontrados.size(); i++)
        {
            System.out.println(produtosEncontrados.get(i));
        }
        
    }
    
    public static void PrintEmptyLine()
    {
        System.out.println();
        System.out.println("****************************");
        System.out.println();
    }
    
    public static void InicializarSeteProdutos()
    {
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(0).
                setName("Computador Positivo").setProductType("Informatica").setBrandOwner("Positivo").
                setPrice(3000).setAvailableAmount(100).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(6).
                setName("Fritadeira AirFrier").setProductType("Eletrodomestico").setBrandOwner("Mondial").
                setPrice(300).setAvailableAmount(1000).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(2).
                setName("Geladeira").setProductType("Eletrodomestico").setBrandOwner("Eletrolux").
                setPrice(1500).setAvailableAmount(12).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(3).
                setName("Mouse Gamer").setProductType("Informatica").setBrandOwner("Red Dragon").
                setPrice(200).setAvailableAmount(55).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(7).
                setName("Notebook Positivo").setProductType("Informatica").setBrandOwner("Positivo").
                setPrice(1500).setAvailableAmount(100).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(5).
                setName("Tenis Casual").setProductType("Roupas").setBrandOwner("Nike").
                setPrice(120).setAvailableAmount(5000).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(1).
                setName("Tenis Esportivo").setProductType("Roupas").setBrandOwner("Nike").
                setPrice(450).setAvailableAmount(5000).getProduto());
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(4).
                setName("Camisa Polo").setProductType("Roupas").setBrandOwner("Polo").
                setPrice(75).setAvailableAmount(0).getProduto());
       
    }
}
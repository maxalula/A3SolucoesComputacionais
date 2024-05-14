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
    Nome: Marcossuel Cerqueira dos Santos  
    RA: 12723215922
}
*/
package com.a3.principal;

import java.util.*;
import GUI.*;

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
        
        Produto[] produtosOrdenados = Estoque.ObterEstoque().ObterEstoquePor(AtributosProduto.NAME, false, "string");
        
        for(int i=0;i<produtosOrdenados.length;i++)
        {
            System.out.println(produtosOrdenados[i]);
        }
        
        PrintEmptyLine();
        
        /*Buscar produtos por nome;
        String buscaFeita = "t";
        ArrayList<Produto> produtosEncontrados = Estoque.ObterEstoque().BuscarProdutoPor(AtributosProduto.NAME, buscaFeita);
        
        for(int i=0; i<produtosEncontrados.size(); i++)
        {
            System.out.println(produtosEncontrados.get(i));
        }
        
        
        PrintEmptyLine();
        //Remover e Listar estoque
        Estoque.ObterEstoque().RemoverProdutoDeID(5);
        for(int i=0;i<Estoque.ObterEstoque().QuantidadeProdutosEstoque();i++)
        {
            System.out.println(Estoque.ObterEstoque().ObterProdutoNoIndice(i));
        }
        
        PrintEmptyLine();
        
        //Modificar um registro e print
        Produto produtoModificado = new ProdutoBuilder().setId(0).
                setName("Computador Gamer Pichau").setProductType("Informatica").setBrandOwner("Pichau").
                setPrice(8000).setAvailableAmount(32).getProduto();
        
        Estoque.ObterEstoque().ModificarProdutoDeID(0, produtoModificado);
        for(int i=0;i<Estoque.ObterEstoque().QuantidadeProdutosEstoque();i++)
        {
            System.out.println(Estoque.ObterEstoque().ObterProdutoNoIndice(i));
        }
        */
        
        InterfaceManager.Instancia().Initialize();
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
        
        Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(1).
                setName("Tenis Esportivo").setProductType("Roupas").setBrandOwner("Nike").
                setPrice(450).setAvailableAmount(5000).getProduto());
        
         Estoque.ObterEstoque().AdicionarProdutoAoEstoque(new ProdutoBuilder().setId(8).
                setName("Suco De Uva").setProductType("Alimentos").setBrandOwner("Kapo").
                setPrice(6).setAvailableAmount(9999).getAlimento().SetCalories(300).SetExpiration("10/12/2024"));
       
    }
}
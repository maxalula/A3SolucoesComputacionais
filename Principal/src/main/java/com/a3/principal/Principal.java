package com.a3.principal;
import java.util.*;
import GUI.*;

public class Principal
{
    public static void main(String[] args)
    {
        //Este metodo inicializa alguns produtos para testes
        InicializarProdutos();
        
        //Este metodo vai carregar a janela inicial do programa
        InterfaceManager.Instancia().Initialize();
    }
    
    public static void InicializarProdutos()
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
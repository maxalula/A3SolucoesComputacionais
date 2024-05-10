package com.a3.principal;

public class Produto
{
    private int id;
    private String name, productType, brandOnwer;
    private int price, availableAmount;
    public Produto(int id, String name, String productType, String brandOnwer, int price, int availableAmount)
    {
        this.id = id;
        this.name = name;
        this.brandOnwer = brandOnwer;
        this.price = price;
        this.productType = productType;
        this.availableAmount = availableAmount;
    }
    
    public String toString()
    {
        return "Produto de ID: " + id + " Nome: " + name + " Marca: " + brandOnwer + " Categoria: " + productType + " Quantidade Disponivel: " + availableAmount + " Preço: " + price;
    }
}

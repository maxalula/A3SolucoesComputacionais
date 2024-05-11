package com.a3.principal;

public class Produto
{
    private int id;
    private String name, productType, brandOwner;
    private int price, availableAmount;
    
    public AtributosProduto OrdenacaoPor;
    
    public int INT_ValorOrdenavel()
    {
        switch(OrdenacaoPor)
        {
            case ID:
              return this.id;

            case PRICE:
              return this.price;

            case AVAILABLE_AMOUNT:
              return this.availableAmount;

            default:
              return this.id;
          }
    }
    public String STRING_ValorOrdenavel()
    {
        switch(OrdenacaoPor)
        {
            case NAME:
              return this.name;

            case PRODUCT_TYPE:
              return this.productType;

            case BRAND_OWNER:
              return this.brandOwner;

            default:
              return this.name;
          }
    }
    /*
    Criar uma classe para armazenar o tipo que vai ser ordenado
    essa classe pode receber um tipo de forma generica
    e retornar de acordo um dos atributos desta classe(this)
    para ordenacao
    
    */
    public Produto(int id, String name, String productType, String brandOwner, int price, int availableAmount)
    {
        this.id = id;
        this.name = name;
        this.brandOwner = brandOwner;
        this.price = price;
        this.productType = productType;
        this.availableAmount = availableAmount;
    }
    
    public String toString()
    {
        return "Produto de ID: " + id + " Nome: " + name + " Marca: " + brandOwner + " Categoria: " + productType + " Quantidade Disponivel: " + availableAmount + " Preço: " + price;
    }
}

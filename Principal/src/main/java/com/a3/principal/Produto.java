package com.a3.principal;
//Classe principal contendo os produtos no qual o sistema vai trabalhar em cima
public class Produto
{
    //declaração dos atributos como protected, para que possam ser usados por classes filhas.
    protected int id;
    protected String name, productType, brandOwner;
    protected int price, availableAmount;
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
    //Seguindo a premissa descrita no livro 'Clean Code: A Handbook of Agile Software Craftsmanship'
    //Simplesmente expor getters e setters torna todos os métodos publicos.
    //Ao longo deste sistema, usaremos os dois métodos como getters para simplificar o projeto e deixar mais lógico. 
    public int INT_ValorOrdenavel(AtributosProduto ordenarPor)
    {
        switch(ordenarPor)
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
    public String STRING_ValorOrdenavel(AtributosProduto ordenarPor)
    {
        switch(ordenarPor)
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
    public void UpdateAmount(boolean increase, int quantity)
    {
        if(increase)
        {
            availableAmount += quantity;
        }
        else
        {
            availableAmount -= quantity;
            if(availableAmount <= 0)
            {
                availableAmount = 0;
            }
        }
    }
    public void UpdateAmount(boolean increase)
    {
        if(increase)
        {
            availableAmount++;
        }
        else
        {
            availableAmount--;
            if(availableAmount <= 0)
            {
                availableAmount = 0;
            }
        }
    }
    public String toString()
    {
        return "Produto de ID: " + id + " Nome: " + name + " Marca: " + brandOwner + " Categoria: " + productType + " Quantidade Disponivel: " + availableAmount + " Preço: " + price;
    }
}

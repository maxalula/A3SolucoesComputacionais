package com.a3.principal;

public class Alimento extends Produto
{
    private String validThru;
    private int calories;
    public Alimento(int id, String name, String productType, String brandOwner, int price, int availableAmount)
    {
        super(id, name, productType, brandOwner, price, availableAmount);
    }
    
    public Alimento SetExpiration(String validThru)
    {
        this.validThru = validThru;
        return this;
    }
    public Alimento SetCalories(int calories)
    {
        this.calories = calories;
        return this;
    }
    
    @Override public String toString()
    {
        String originalReturn = "Produto de ID: " + id + " Nome: " + name + " Marca: " + brandOwner + " Categoria: " + productType +
                " Quantidade Disponivel: " + availableAmount + " Preço: " + price;
        return originalReturn + "\n" + "Válido até: " + validThru + " "+calories + " calorias.";
    }
}

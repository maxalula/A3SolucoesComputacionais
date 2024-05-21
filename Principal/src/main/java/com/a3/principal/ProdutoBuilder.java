package com.a3.principal;

public class ProdutoBuilder
{
    //Classe criada com o intuito de facilitar a criação de classes do tipo Produto
    //Fazendo uso do Design Paterrn Builder, é possível ignorar as limitações de um método construtor.
    private int id;
    private String name, productType, brandOwner;
    private int price, availableAmount;

    /**
     * @param id the id to set
     */
    public ProdutoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * @param name the name to set
     */
    public ProdutoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param productType the productType to set
     */
    public ProdutoBuilder setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    /**
     * @param brandOnwer the brandOnwer to set
     */
    public ProdutoBuilder setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
        return this;
    }

    /**
     * @param price the price to set
     */
    public ProdutoBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    /**
     * @param availableAmount the availableAmount to set
     */
    public ProdutoBuilder setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
        return this;
    }
    
    public Produto getProduto()
    {
        return new Produto(this.id, this.name, this.productType, this.brandOwner, this.price, this.availableAmount);
    }
    public Alimento getAlimento()
    {
        return new Alimento(this.id, this.name, this.productType, this.brandOwner, this.price, this.availableAmount);
    }
    
}

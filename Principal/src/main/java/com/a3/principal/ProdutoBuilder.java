package com.a3.principal;

public class ProdutoBuilder
{
    private int id;
    private String name, productType, brandOnwer;
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
    public ProdutoBuilder setBrandOnwer(String brandOnwer) {
        this.brandOnwer = brandOnwer;
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
        return new Produto(this.id, this.name, this.productType, this.brandOnwer, this.price, this.availableAmount);
    }
    
}

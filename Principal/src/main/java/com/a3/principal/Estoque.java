package com.a3.principal;

import java.util.*;

public class Estoque
{
    /*Fazendo uso do Design Pattern 'Singleton', nós criamos 
    a classe Estoque, e garantimos que apenas exista uma instância dela
    */
    //Instancia de estoque que será usada durante execução do código
    private static final Estoque estoque = new Estoque();
    
    //Com o construtor 'private', não será possível criar outras instâncias, havendo assim apenas um único estoque.
    private Estoque() { }
    
    //Esse metódo será usado para obter acesso ao estoque
    public static Estoque ObterEstoque()
    {
        return estoque;
    }
    /* A ArrayList de produtos é inicializada aqui,
    E as chamadas para manipulação são abstraidas em métodos
    publicos da instancia de Estoque, não sendo possível
    adicionar, remover ou acessar diretamente a ArrayList 'produtosEmEstoque'.
    */
    private ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();
    public void AdicionarProdutoAoEstoque(Produto produto)
    {
        produtosEmEstoque.add(produto);
    }
    public void RemoverProdutoDoEstoque(int indiceNaLista)
    {
        produtosEmEstoque.remove(indiceNaLista);
    }
    public Produto ObterProdutoNoIndice(int indice)
    {
        return produtosEmEstoque.get(indice);
    }
    public int QuantidadeProdutosEstoque()
    {
        return produtosEmEstoque.size();
    }
    public Produto[] ObterEstoquePor(AtributosProduto atributosProduto, boolean ordemCrescente, String tipoOrdenacao)
    {
        Produto[] arrayProdutos = new Produto[produtosEmEstoque.size()];
        for(int i=0;i<arrayProdutos.length;i++)
        {
            arrayProdutos[i] = produtosEmEstoque.get(i);
            arrayProdutos[i].OrdenacaoPor = atributosProduto;
        }
        
        return GerenciadorOrdenacao.ObterEstoqueOrdenado(arrayProdutos, ordemCrescente, tipoOrdenacao);
    }
    
    public ArrayList<Produto> BuscarProdutoPor(AtributosProduto atributosProduto, String criterioBusca)
    {
        criterioBusca = criterioBusca.toLowerCase();
        
        ArrayList<Produto> arrayProdutos = new ArrayList<Produto>();
        
        for(int i=0; i<produtosEmEstoque.size(); i++)
        {
            produtosEmEstoque.get(i).OrdenacaoPor = atributosProduto;
            
            if(produtosEmEstoque.get(i).STRING_ValorOrdenavel().toLowerCase().contains(criterioBusca))
            {
                arrayProdutos.add(produtosEmEstoque.get(i));
            }
        }
        
        return arrayProdutos;
    }
}
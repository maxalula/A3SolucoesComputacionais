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
    public Produto[] ObterArrayProduto()
    {
        //Metodo para retornar o estoque em Array
        return ListaParaVetor(produtosEmEstoque);
    }
    public Produto[] ListaParaVetor(ArrayList<Produto> lista)
    {
        //Metodo para retornar o estoque em Array
        Produto[] produtos = new Produto[lista.size()];
        for(int i=0; i<produtos.length; i++)
        {
            produtos[i] = lista.get(i);
        }
        return produtos;
    }
    public void AdicionarProdutoAoEstoque(Produto produto)
    {
        int idProduto = produto.INT_ValorOrdenavel(AtributosProduto.ID);
        if(!ContemProdutoDeID(idProduto))
        {
            produtosEmEstoque.add(produto);
        }
        else
        {
            Produto produtoEncontrado = RetornarProdutoDeID(idProduto);
            produtoEncontrado.UpdateAmount(true, produto.INT_ValorOrdenavel(AtributosProduto.AVAILABLE_AMOUNT));
        }
    }
    public boolean ContemProdutoDeID(int id)
    {
        for(int i=0;i<produtosEmEstoque.size();i++)
        {
            if(produtosEmEstoque.get(i).INT_ValorOrdenavel(AtributosProduto.ID) == id)
            {
                return true;
            }
        }
        
        return false;
    }
    public Produto RetornarProdutoDeID(int id)
    {
        for(int i=0;i<produtosEmEstoque.size();i++)
        {
            if(produtosEmEstoque.get(i).INT_ValorOrdenavel(AtributosProduto.ID) == id)
            {
                return produtosEmEstoque.get(i);
            }
        }
        
        return null;
    }
    public void RemoverProdutoDeID(int id)
    {
        for(int i=0;i<produtosEmEstoque.size();i++)
        {
            if(produtosEmEstoque.get(i).INT_ValorOrdenavel(AtributosProduto.ID) == id)
            {
                RemoverProdutoDoEstoque(i);
                break;
            }
        }
    }
    public void ModificarProdutoDeID(int id, Produto produtoModificado)
    {
        for(int i=0;i<produtosEmEstoque.size();i++)
        {
            if(produtosEmEstoque.get(i).INT_ValorOrdenavel(AtributosProduto.ID) == id)
            {
                produtosEmEstoque.set(i, produtoModificado);
                break;
            }
        }
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
        }
        
        return GerenciadorOrdenacao.ObterEstoqueOrdenado(arrayProdutos, ordemCrescente, tipoOrdenacao, atributosProduto);
    }
    
    public Produto[] BuscarProdutoPor(AtributosProduto atributosProduto, String criterioBusca)
    {
        criterioBusca = criterioBusca.toLowerCase();
        
        ArrayList<Produto> arrayProdutos = new ArrayList<Produto>();
        
        for(int i=0; i<produtosEmEstoque.size(); i++)
        {
            //produtosEmEstoque.get(i).OrdenacaoPor = atributosProduto;            
            if(produtosEmEstoque.get(i).STRING_ValorOrdenavel(atributosProduto).toLowerCase().contains(criterioBusca))
            {
                arrayProdutos.add(produtosEmEstoque.get(i));
            }
        }
        
        return ListaParaVetor(arrayProdutos);
    }
    public void ComprarProduto(Produto produto)
    {
        produto.UpdateAmount(false);
    }
}
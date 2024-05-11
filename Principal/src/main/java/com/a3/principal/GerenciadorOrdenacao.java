package com.a3.principal;

public class GerenciadorOrdenacao
{
    //Metodo estatico responsavel por ordenar produtos
    public static Produto[] ObterEstoqueOrdenado(Produto[] produtos, boolean inverter, String tipoVariavel)
    {
        if(tipoVariavel.equals("int"))
        {
            return INT_OrdenarEstoque(produtos, inverter);
        }
        else
        {
            return STR_OrdenarEstoque(produtos, inverter);
        }
    }
    
    private static Produto[] INT_OrdenarEstoque(Produto[] produtos, boolean inverter)
    {
        for (int i = 1; i < produtos.length; i++)
        {
            Produto currentValue = produtos[i];//.ValorOrdenavel();
            int j = i - 1;// J starts a index Before the current I
            if(inverter)
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel() > currentValue.INT_ValorOrdenavel())//Jay cannot go past the index 0(duh) and Sorting Criteria
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            else
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel() < currentValue.INT_ValorOrdenavel())//Jay cannot go past the index 0(duh) and Sorting Criteria
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            produtos[j + 1] = currentValue;
        }
        
        return produtos;
    }
    private static Produto[] STR_OrdenarEstoque(Produto[] produtos, boolean inverter)
    {
        //TODO: Retornar em ordem alfabetica / invertida
        return produtos;
    }
}

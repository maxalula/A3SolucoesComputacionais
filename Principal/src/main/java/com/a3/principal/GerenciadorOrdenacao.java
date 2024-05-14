package com.a3.principal;

import java.util.*;

public class GerenciadorOrdenacao
{
    //Metodo estatico responsavel por ordenar produtos
    public static Produto[] ObterEstoqueOrdenado(Produto[] produtos, boolean inverter, String tipoVariavel, AtributosProduto ordenarPor)
    {
        if(tipoVariavel.equals("int"))
        {
            return INT_OrdenarEstoque(produtos, inverter, ordenarPor);
        }
        else
        {
            return STR_OrdenarEstoque(produtos, inverter, ordenarPor);
        }
    }
    
    private static Produto[] INT_OrdenarEstoque(Produto[] produtos, boolean inverter, AtributosProduto ordenarPor)
    {
        for (int i = 1; i < produtos.length; i++)
        {
            Produto currentValue = produtos[i];//.ValorOrdenavel();
            int j = i - 1;// J starts a index Before the current I
            if(inverter)
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel(ordenarPor) > currentValue.INT_ValorOrdenavel(ordenarPor))//Jay cannot go past the index 0(duh) and Sorting Criteria
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            else
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel(ordenarPor) < currentValue.INT_ValorOrdenavel(ordenarPor))//Jay cannot go past the index 0(duh) and Sorting Criteria
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            produtos[j + 1] = currentValue;
        }
        
        return produtos;
    }
    private static Produto[] STR_OrdenarEstoque(Produto[] produtos, boolean inverter, AtributosProduto ordenarPor)
    {
        //Crio uma lista vazia
        ArrayList<String> produtosLista = new ArrayList<String>();
        //Percorro os produtos passados
        for (int i = 0; i < produtos.length; i++)
        {
            //Salvo a String que vai ser usada em ordem alfabetica e adiciono na lista de Strings criada acima
            String atributoString = produtos[i].STRING_ValorOrdenavel(ordenarPor);
            produtosLista.add(atributoString);
        }
        /*Faço uso da collections.sort (do java) para organizar as strings
        E uso comparator para trazer a ordem reversa.
        
        Créditos à https://www.baeldung.com/java-sort-list-alphabetically
        que mostra exemplos de uso destas classes.
        */
        if(inverter)
        {
            Comparator<String> reverseComparator = Comparator.reverseOrder();
            Collections.sort(produtosLista, reverseComparator); 
        }
        else
        {
            Collections.sort(produtosLista);   
        }
        //Eu crio um loop externo, passando pela lista de String, atualmente organizada
        for (int i = 0; i < produtosLista.size(); i++)
        {
            //Eu crio um loop interno, passando pela arrayOriginal de produtos
            for(int j=0; j < produtos.length; j++)
            {
                //Ao encontrar um produto cujo valor seja igual ao String atual da lista, ele é trocado de lugar
                if(produtosLista.get(i) == produtos[j].STRING_ValorOrdenavel(ordenarPor) && i != j)//Pularemos iterações onde os 2 indices forem iguais
                {
                    Produto tempProduto = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = tempProduto;
                    break;
                }
            }
        }
        //TODO: Retornar em ordem alfabetica / invertida
        return produtos;
    }
}

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
    //Aqui é implementado a lógica de Insertion Sort, para organizar um vetor de inteiros.
    //Fiz algumas modificações para que fosse possível organizar um vetor de classe baseado num atributo inteiro, e adicionei uma boolean
    //para organizar na ordem inversa.
    private static Produto[] INT_OrdenarEstoque(Produto[] produtos, boolean inverter, AtributosProduto ordenarPor)
    {
        for (int i = 1; i < produtos.length; i++)
        {
            Produto currentValue = produtos[i];
            int j = i - 1;
            if(inverter)
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel(ordenarPor) > currentValue.INT_ValorOrdenavel(ordenarPor))
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            else
            {
                while (j >= 0 && produtos[j].INT_ValorOrdenavel(ordenarPor) < currentValue.INT_ValorOrdenavel(ordenarPor))
                {
                    produtos[j + 1] = produtos[j];
                    j--;
                }
            }
            produtos[j + 1] = currentValue;
        }
        
        return produtos;
    }
    //Aqui eu faço uso do Collections.sort do próprio java para organizar em ordem alfabetica
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
        
        return produtos;
    }
}

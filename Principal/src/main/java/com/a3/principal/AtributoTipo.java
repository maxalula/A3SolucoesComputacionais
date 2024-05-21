package com.a3.principal;
public class AtributoTipo <AtributosProduto, String>
{
    //Essa classe cria um 'Key-Pair', que age como uma variável com 2 tipos diferentes
    //Foi criado para resolver um problema onde se precisava passar o tipo do produto e uma string auxiliar.
    public final AtributosProduto a;
    public final String b;

    public AtributoTipo(AtributosProduto a, String b)
    {
        this.a = a;
        this.b = b;
    }
};
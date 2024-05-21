package Connections;

import com.a3.principal.Produto;
import java.util.ArrayList;

public class Account
{
    /*
    CLASSE CRIADA PARA SER A CONTA DO USUÁRIO NO SISTEMA
    ATRIBUTOS BEM SIMPLES E AUTO EXPLICATIVOS
    */
    private String usuario, senha;
    private ArrayList<Produto> produtosComprados = new ArrayList<Produto>();
    public Account(String usuario, String senha)
    {
        this.usuario = usuario;
        this.senha = senha;
    }
    //Metodo para adicionar produtos 
    public void ComprarProduto(Produto produto)
    {
        produtosComprados.add(produto);
    }
    //Sobrecarga para compar um vetor com vários produtos
    public void ComprarProduto(Produto[] produto)
    {
        //Produtos com mesmo id são empilhados
        for(int i=0;i<produto.length;i++)
        {
            produtosComprados.add(produto[i]);
        }
    }
    
    public String GetUsuario()
    {
        return usuario;
    }
    public String GetSenha()
    {
        return senha;
    }
}
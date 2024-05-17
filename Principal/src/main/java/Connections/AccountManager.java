package Connections;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AccountManager
{
    //Singleton para gerenciar contas
    private static final AccountManager accountManager = new AccountManager();
    private boolean loginRealizado;
    private Account contaLogada;
    
    private ArrayList<Account> contasRegistradas = new ArrayList<Account>();
    //Com o construtor 'private', não será possível criar outras instâncias, havendo assim apenas um único estoque.
    private AccountManager() { }
    
    //Esse metódo será usado para obter acesso ao estoque
    public static AccountManager Instancia()
    {
        return accountManager;
    }
    public boolean UsuarioConectado()
    {
        return loginRealizado;
    }
    private void SetLoginRealizado(Account account)
    {
        contaLogada = account;
        loginRealizado = true;
    }
    public void SairConta()
    {
        contaLogada = null;
        loginRealizado = false;
    }
    public boolean RealizarLogin(String u, String s)
    {
        if(contasRegistradas.size() > 0)
        {
            for(int i=0;i<contasRegistradas.size();i++)
            {
                if(u.equals(contasRegistradas.get(i).GetUsuario()) && s.equals(contasRegistradas.get(i).GetSenha()))
                {
                    SetLoginRealizado(contasRegistradas.get(i));
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso.");
                    return true;
                }
            }
            
            if(!UsuarioConectado())
            {
                JOptionPane.showMessageDialog(null, "Conta não cadastrada no sistema.");
            }
            return false;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Conta não cadastrada no sistema.");
            return false;
        }
    }
    public boolean RealizarCadastro(String u, String s)
    {
        Account contaNova = new Account(u,s);
        contasRegistradas.add(contaNova);
        SetLoginRealizado(contaNova);
        JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso.");
        return true;
    }
}
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class FactoryConnection
{
    //Constantes com as credenciais do BACKEND
    private static final String url = "";
    private static final String usuario = "";
    private  static final String senha = "";
    public static Connection GetConnection()
    {    
        Connection connection = null;
        try
        {     
             connection = DriverManager.getConnection(url, usuario, senha);
             //JOptionPane.showMessageDialog(null, "conectado com sucesso");
             
        }
        catch
            (Exception exception)
            {
                JOptionPane.showMessageDialog(null, "Erro de conexao com o banco de dados:" + exception);
            }
        
        return connection;
    }
}

package br.com.dobackaofront.principal;


public class Account {
    private String nome = "Gabriel";
    private String senha = "1606";
    private String Pnome = "Arroz";
    private String preco = "R$7,00";
    private String tipo = "Alimentício";
    private String qtnd = "10";
    
    public String getnome(){
        return nome;
    }
    
    public String getsenha(){
        return senha;
    }
    
    public String getPnome(){
        return Pnome;
    }
    public void setPnome(String Pnome){
        this.Pnome = Pnome;
    }
    
    public String getpreco(){
        return preco;
    }
    public void setpreco(String preco){
        this.preco = preco;
    }
    
    public String gettipo(){
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getqtnd(){
        return qtnd;
    }
    public void setqtnd(String qtnd){
        this.qtnd = qtnd;
    }
    
}

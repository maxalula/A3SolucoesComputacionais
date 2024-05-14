package GUI;

public class InterfaceManager
{
    //Fazendo uso do design pattern singleton, pois haverá apenas um Manager(Gerenciador) para interface.
    private static final InterfaceManager interfaceManager = new InterfaceManager();
    
    //Com o construtor 'private', não será possível criar outras instâncias, havendo assim apenas um único estoque.
    private InterfaceManager() { }
    
    //Esse metódo será usado para obter acesso ao estoque
    public static InterfaceManager Instancia()
    {
        return interfaceManager;
    }
    private javax.swing.JFrame currentFrame;
    public void Initialize()
    {
        currentFrame = new Index();
        currentFrame.setVisible(true);
    }
    public void SwitchWindow(int windowId)
    {
        currentFrame.setVisible(false);
        
        switch(windowId)
        {
            case 0:
                currentFrame = new Index();
                currentFrame.setVisible(true);
                break;
            case 1:
                EstoqueDisplay estoqueDisplay = new EstoqueDisplay();
                estoqueDisplay.UpdateTable();
                currentFrame = estoqueDisplay;
                currentFrame.setVisible(true);
                break;
            case 2:
                /*currentFrame = new Index();
                currentFrame.setVisible(true);*/
                break;
            default:
                currentFrame = new Index();
                currentFrame.setVisible(true);
        }
    }
}

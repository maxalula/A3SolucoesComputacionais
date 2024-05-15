package GUI;

import com.a3.principal.*;

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
                currentFrame = new EstoqueDisplay();
                ((EstoqueDisplay)currentFrame).UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                currentFrame.setVisible(true);
                break;
            case 2:
                currentFrame = new AdicionarEstoque();
                currentFrame.setVisible(true);
                break;
            case 3:
                currentFrame = new EstoqueManagement();
                ((EstoqueManagement)currentFrame).UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                currentFrame.setVisible(true);
                break;
            default:
                currentFrame = new Index();
                currentFrame.setVisible(true);
        }
    }
    public void CreateExclusionForm(int productId)
    {
        ExlusionForm exclusionForm = new ExlusionForm();
        exclusionForm.InitializeWindow(Estoque.ObterEstoque().RetornarProdutoDeID(productId));
        exclusionForm.setVisible(true);
    }
    public void UpdateEstoqueManagementAfterExclusion()
    {
        ((EstoqueManagement)currentFrame).UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
    }
    public void CreateEditionForm(int productId)
    {
        EditionForm editionForm = new EditionForm();
        editionForm.InitializeWindow(Estoque.ObterEstoque().RetornarProdutoDeID(productId));
        editionForm.setVisible(true);
    }
}
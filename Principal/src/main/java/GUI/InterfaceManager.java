package GUI;

import com.a3.principal.*;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private JFrame currentFrame = new JFrame("Sistema");
    private JPanel panelCont = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    /* PANELS */
    private Index index = new Index();
    private EstoqueDisplay estoqueDisplay = new EstoqueDisplay();
    private AdicionarEstoque adicionarEstoque = new AdicionarEstoque();
    private EstoqueManagement estoqueManagement = new EstoqueManagement();
    private LoginDisplay loginDisplay = new LoginDisplay();
    private RegistroDisplay registroDisplay = new RegistroDisplay();
    private JanelaCompra janelaCompra = new JanelaCompra();
    /*         */
    public void Initialize()
    {
        //Adiciono as janelas no layout do projeto
        panelCont.setLayout(cardLayout);
        panelCont.add(index.getContentPane(), "1");
        panelCont.add(estoqueDisplay.getContentPane(), "2");
        panelCont.add(adicionarEstoque.getContentPane(), "3");
        panelCont.add(estoqueManagement.getContentPane(), "4");
        panelCont.add(loginDisplay.getContentPane(), "5");
        panelCont.add(registroDisplay.getContentPane(), "6");
        panelCont.add(janelaCompra.getContentPane(), "7");
        cardLayout.show(panelCont, "1");
        
        currentFrame.add(panelCont);
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentFrame.pack();
        currentFrame.setVisible(true);
        
    }
    //Metodo para altrar janelas baseado no id
    public void SwitchWindow(int windowId)
    {
        switch(windowId)
        {
            case 0:
                cardLayout.show(panelCont, "1");
                break;
            case 1:
                estoqueDisplay.UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                cardLayout.show(panelCont, "2");
                //((EstoqueDisplay)currentFrame).UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                break;
            case 2:                
                cardLayout.show(panelCont, "3");
                break;
            case 3:
                //((EstoqueManagement)currentFrame).UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                estoqueManagement.UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
                cardLayout.show(panelCont, "4");
                break;
            case 4:
                cardLayout.show(panelCont, "5");
                break;
            case 5:
                cardLayout.show(panelCont, "6");
                break;
            case 6:
                janelaCompra.Initialize(Estoque.ObterEstoque().ObterArrayProduto());
                cardLayout.show(panelCont, "7");
                break;
            default:
                cardLayout.show(panelCont, "1");
        }
    }
    public void CreateExclusionForm(int productId)
    {
        ExlusionForm exclusionForm = new ExlusionForm();
        exclusionForm.InitializeWindow(Estoque.ObterEstoque().RetornarProdutoDeID(productId));
        exclusionForm.setVisible(true);
    }
    public void CreateEditionForm(int productId)
    {
        EditionForm editionForm = new EditionForm();
        editionForm.InitializeWindow(Estoque.ObterEstoque().RetornarProdutoDeID(productId));
        editionForm.setVisible(true);
    }
    public void UpdateEstoqueManagementAfterEdition()
    {
        estoqueManagement.UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
        estoqueDisplay.UpdateTable(Estoque.ObterEstoque().ObterArrayProduto());
    }
}
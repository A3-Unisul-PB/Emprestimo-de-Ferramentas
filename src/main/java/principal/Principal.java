/**
 * O pacote principal contém a classe principal do programa.
 */
package principal;

// Importação da classe FrmMenuPrincipal do pacote view.
import view.FrmMenuPrincipal;

/**
 * A classe Principal é a classe principal do programa.
 * Ela contém o método main, que é o ponto de entrada do programa.
 */
public class Principal {
    /**
     * O método main é o ponto de entrada do programa.
     * Ele cria uma instância da classe FrmMenuPrincipal e a torna visível.
     *
     * @param args Argumentos da linha de comando. Não são utilizados neste programa.
     */
    public static void main(String[] args) {
        // Cria uma nova instância da classe FrmMenuPrincipal.
        FrmMenuPrincipal menu = new FrmMenuPrincipal();
        
        // Torna a instância do menu visível.
        menu.setVisible(true);
    }
}


package petshop;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import tela.FrmUsarioLogin;

public class PetShop {

    public static void main(String[] args) {
        // if e else para carregar o banco de dados e botar  janela na tela 
        if (ConexaoBD.getInstance().getConnection()  != null){
            new FrmUsarioLogin().setVisible(true);
        } else{
           JOptionPane.showMessageDialog(null,"Erro ao conectar no Banco De Dados.");
        }
        
        
    }
}

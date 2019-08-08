/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.EscolaDao;
import javax.swing.JOptionPane;
import modelo.Escola;
import tela.manutencao.ManutencaoEscola;
/**
 *
 * @author Administrador
 */
public class ControladorEscola {
    public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setArea(Integer.parseInt(man.jtfArea.getText()));
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setNumerodealunos(Integer.parseInt(man.jtfNumerodealunos.getText()));
        objeto.setEndereco(man.jtfNome.getText());
        
        boolean resultado = EscolaDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    public static void alterar(ManutencaoProduto man){
        Produto objeto = new Produto();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setDescricao(man.jtfDescricao.getText());
        
        boolean resultado = DaoProduto.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}

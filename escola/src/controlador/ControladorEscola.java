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
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorEscola {
    public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
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
    public static void alterar(ManutencaoEscola man){
        Escola objeto = new Escola();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setSigla(man.jtfSigla.getText());        
        objeto.setNumerodealunos(Integer.parseInt(man.jtfNumerodealunos.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));


        
        boolean resultado = EscolaDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela

        modelo.addColumn("NOME");
        modelo.addColumn("SIGLA");
        modelo.addColumn("NÚMERO DE ALUNOS");
        List<Escola> resultados = EscolaDao.consultar();
        for (Escola objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
           
            linha.add(objeto.getNome());
            linha.add(objeto.getSigla());
            linha.add(objeto.getNumerodealunos());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}

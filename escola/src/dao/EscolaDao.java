/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;
/**
 *
 * @author Administrador
 */
public class EscolaDao {
     public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO escola (nome, endereco, sigla, nrdealunos, area) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEndereco());
            ps.setString(3, objeto.getSigla());
            ps.setInt(4, objeto.getNumerodealunos());
            ps.setInt(5, objeto.getArea());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
     public static void main(String[] args) {
        Escola objeto = new Escola();
        objeto.setNome("IF Ibirubá");
        objeto.setEndereco("Brasil");
        objeto.setSigla("IFRS");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     
    /**
     *
     * @param objeto
     * @return
     */
    public static boolean alterar(Escola objeto) {
        String sql = "UPDATE escola SET nome = ?, endereco = ?, sigla=?, nrdealunos=?, area=? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getEndereco());
            ps.setString(3, objeto.getSigla());
            ps.setString(4, objeto.getNumerodealunos());
            ps.setString(5, objeto.getArea());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}

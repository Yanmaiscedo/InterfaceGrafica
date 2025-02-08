  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import connection.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Tarefa;

/**
 *
 * @author yanma
 */
public class TarefaDAO {
    
    public void create(Tarefa t){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cadastro_tarefas (estado,importancia,nome,descricao,tipo,datafinal)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, t.getEstado());
            stmt.setString(2, t.getImportancia());
            stmt.setString(3, t.getNome());
            stmt.setString(4, t.getDescricao());
            stmt.setString(5, t.getTipo());
            stmt.setString(6, t.getDatafinal());
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
    public List<Tarefa> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tarefa> tarefas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT *FROM cadastro_tarefas");
            rs = stmt.executeQuery();
            while (rs.next()){
                Tarefa tarefa = new Tarefa();
                
                tarefa.setId(rs.getInt("id"));
                tarefa.setEstado(rs.getString("estado"));
                tarefa.setImportancia(rs.getString("importancia"));
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setTipo(rs.getString("tipo"));
                tarefa.setDatafinal(rs.getString("datafinal"));
                tarefas.add(tarefa);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler tarefa xiiiiiiiii"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
        
        return tarefas;
        
    }


    
     public void update(Tarefa t){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cadastro_tarefas SET estado = ? ,importancia = ? ,nome = ? ,descricao = ? ,tipo = ? ,datafinal = ? WHERE id = ?");
            stmt.setString(1, t.getEstado());
            stmt.setString(2, t.getImportancia());
            stmt.setString(3, t.getNome());
            stmt.setString(4, t.getDescricao());
            stmt.setString(5, t.getTipo());
            stmt.setString(6, t.getDatafinal());
            stmt.setInt(7, t.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
     
         
     public void delete(Tarefa t){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cadastro_tarefas WHERE id = ?");
            stmt.setInt(1, t.getId());
            
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
     
     
     public void contador(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT" + 
                                        "SUM(CASE WHEN estado = 'Concluido' THEN 1 ELSE 0 END) AS concluido," +
                                        "SUM(CASE WHEN estado != 'Concluido' THEN 1 ELSE 0 END) AS naoConcluido" +
                                        "FROM cadastro_tarefas");
            rs = stmt.executeQuery();
            if (rs.next()) {
                int concluido = rs.getInt("concluido");
                int naoConcluido = rs.getInt("naoConcluido");

                JOptionPane.showMessageDialog(null, 
                    "Tarefas Concluídas: " + concluido + "\nTarefas Não Concluídas: " + naoConcluido);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao obter progresso das tarefas:"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
     
     
     public List<Tarefa> leitura(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tarefa> tarefas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT *FROM cadastro_tarefas");
            rs = stmt.executeQuery();
            while (rs.next()){
                Tarefa tarefa = new Tarefa();
                
                tarefa.setId(rs.getInt("id"));
                tarefa.setEstado(rs.getString("estado"));
                tarefa.setImportancia(rs.getString("importancia"));
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setTipo(rs.getString("tipo"));
                tarefa.setDatafinal(rs.getString("datafinal"));
                tarefas.add(tarefa);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler tarefa xiiiiiiiii"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
        
        return tarefas;
        
    }
     
     
     
     
     public List<Tarefa> ler(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tarefa> tarefas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT *FROM cadastro_tarefas");
            rs = stmt.executeQuery();
            while (rs.next()){
                Tarefa tarefa = new Tarefa();
                
                tarefa.setId(rs.getInt("id"));
                tarefa.setEstado(rs.getString("estado"));
                tarefa.setImportancia(rs.getString("importancia"));
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setTipo(rs.getString("tipo"));
                tarefa.setDatafinal(rs.getString("datafinal"));
                tarefas.add(tarefa);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler tarefa xiiiiiiiii"+ex);
        }finally{
            Conexao.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
        
        return tarefas;
        
    }
     /*
     public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaTarefa.getModel();
        modelo.setNumRows(0);
        TarefaDAO tdao = new TarefaDAO();
        for (Tarefa t : tdao.read()) {
            modelo.addRow(new Object[]{
                t.getId(),
                t.getEstado(),
                t.getImportancia(),
                t.getNome(),
                t.getDescricao(),
                t.getTipo(),
                t.getDatafinal()
            });
        }
     */
    
}










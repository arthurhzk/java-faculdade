/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Servico;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class ServicoDAO implements IDAOT<Servico> {

    @Override
    public String salvar(Servico o) {
        //insercao       
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql="insert into servico (id, nome, preco) "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome()+ "', "
                    + "'" + o.getPreco()+ "') ";
            
            int retorno = st.executeUpdate(sql);
            return null;
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar SERVIÇO!" + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Servico o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Servico> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Servico> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Servico consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

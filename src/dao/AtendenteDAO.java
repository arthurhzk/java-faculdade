/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Atendente;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class AtendenteDAO implements IDAOT<Atendente> {

    @Override
    public String salvar(Atendente o) {
        //insercao       
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql="insert into atendente (id, nome, usuario, cargo) "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome()+ "', "
                    + "'" + o.getUsuario()+ "', "
                    + "'" + o.getCargo()+ "');";
            
            int retorno = st.executeUpdate(sql);
            return null;
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar ATENDENTE!" + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Atendente o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Atendente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Atendente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Atendente consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

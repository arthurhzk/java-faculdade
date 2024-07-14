/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Servico;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
            
            String sql="insert into servico (id, nome, preco, atendente_id) "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getPreco() + "', "
                    + o.getAtendente().getId() + ")";
            
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
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql= "delete from servico "
                    + "where id = " + id;
            
            System.out.println("SQL: " + sql);
            
            int retorno = st.executeUpdate(sql);
            return null;
            
        }catch(Exception e){
            System.out.println("Erro ao EXCLUIR SERVICO!" + e);
            return e.toString();
        }
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
    
    public void popularTabela(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Preco";
        cabecalho[3] = "Atendente";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM servico "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao CONSULTAR SERVIÇO: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT s.id, s.nome, s.preco, a.nome AS atendente_nome "
                    + "FROM servico s "
                    + "JOIN atendente a ON s.atendente_id = a.id "
                    + "WHERE "
                    + "s.nome ILIKE '%" + criterio + "%' order by s.id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getFloat("preco");
                dadosTabela[lin][3] = resultadoQ.getString("atendente_nome");

                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para POPULAR tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {
                if (column == 2) {
                    return Float.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
                case 3:
                    column.setPreferredWidth(100);
                    break;
            }
        }
    }
}

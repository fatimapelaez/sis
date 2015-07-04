package br.com.construtora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.construtora.model.Obra;

public class ObraDao implements InterfaceDao {

	private Connection con;

	// contrutor classe executa conex�o com banco de dados
	public ObraDao() throws SQLException { 
		con = new ConexaoBd().conectaBD();
	}

	@Override
	public void incluirDadosBd(Obra obra) throws SQLException {
		String sql = "insert into tb_obra (id_obra, sigla_obra, local_obra) values (?,?)";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setLong(1, obra.getIdObra());
		stm.setString(2, obra.getSiglaObra());
		stm.setString(3, obra.getLocalObra());
		stm.executeUpdate();
		stm.close();	
	}


	@Override
	public void alterarDadosBd(Obra obra) throws SQLException {
		String sql = "update tb_obra set sigla_obra=?, local_obra=?," + "where id_obra=?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, obra.getSiglaObra());
		stm.setString(2, obra.getLocalObra());
		stm.setLong(3, obra.getIdObra());
		stm.execute();
		stm.close();		
	}

	
	@Override
	public void excluirDadosBd(Obra obra) throws SQLException {
		String sql = "delete form tb_obra where id_obra=?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setLong(1, obra.getIdObra());
		stm.executeUpdate();
		stm.close();
	}

	
	@Override
	public List<Obra> consultarDadosBd() throws SQLException {
		String sql = "select * from tb_obra";
		List<Obra> obras = new ArrayList<Obra>();
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Obra obra = new Obra();
			obra.setIdObra(rs.getInt("id_obra"));
			obra.setSiglaObra(rs.getString("sigla_obra"));
			obra.setLocalObra(rs.getString("local_obra"));
		}
		rs.close();
		stm.close();
		return obras;
	}		
}
	




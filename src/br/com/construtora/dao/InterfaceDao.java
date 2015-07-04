package br.com.construtora.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.construtora.model.Obra;

public interface InterfaceDao {

	public abstract void incluirDadosBd(Obra obra) throws SQLException;

	public abstract void alterarDadosBd(Obra obra) throws SQLException;

	public abstract void excluirDadosBd(Obra obra) throws SQLException;

	public abstract List<Obra> consultarDadosBd() throws SQLException;

}
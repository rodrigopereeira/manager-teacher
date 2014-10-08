package br.com.rodrigo.integrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.integrador.jdbc.ConnectionFactory;
import br.com.rodrigo.integrador.modelo.Menu;

public class MenuDAO {
	
Connection connection;
	
	public MenuDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public List<Menu> lista(int codigoGrupo){
		String sql = ("select * from menuGrupo AS mg "
				+ "INNER JOIN menuSistema AS ms "
				+ "ON ms.codMenu = mg.codMenu "
				+ "where codGrupo = ? ORDER BY ms.nivelMenu, ms.ordemMenu");
		try{
			List<Menu> menus = new ArrayList<Menu>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, codigoGrupo);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Menu menu = new Menu();
				menu.setCodMenu(rs.getInt("codMenu"));
				menu.setNomeMenu(rs.getString("nomeMenu"));
				menu.setDescricaoMenu(rs.getString("descricaoMenu"));
				menu.setTipoMenu(rs.getString("tipoMenu"));
				menu.setAtivoMenu(rs.getString("ativoMenu"));
				menu.setNivelMenu(rs.getInt("nivelMenu"));
				menu.setUrlMenu(rs.getString("urlMenu"));
				menu.setOrdemMenu(rs.getInt("ordemMenu"));
				menu.setCodMenuPai(rs.getInt("codMenuPai"));

				//adicionar objeto a lista
				menus.add(menu);
			}
			rs.close();
			stmt.close();

			return menus;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
}

package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//Classe utilitaire pour mutualiser la connexion à la base de données

public abstract class ConnectionProvider {
	public static Connection getConnection() throws DALException {

		try {
			Context context = new InitialContext();

			String chemin = "java:comp/env/";
			String bd = System.getenv("NOM_BASE_DE_DONNEES");
			String c = chemin.concat(bd);
			DataSource dataSource = (DataSource) context.lookup(c);

			Connection cnx = dataSource.getConnection();
			if (!cnx.isClosed()) {
				System.out.println("La connexion est ouverte");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
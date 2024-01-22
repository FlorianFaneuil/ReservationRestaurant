package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletTestConnexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

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
	}
}

package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class ConnectionTestServlet2
 */
@WebServlet("/ConnectionTestServlet2")
public class ConnectionTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionTestServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			InitialContext ctx =
					new InitialContext();
			DataSource ds =
					(DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();
			log("接続しました");
		} catch (Exception e) {
			throw new ServletException(e);
		}finally {

			try {
				if(con != null) {
					con.close();
					log("切断しました");
				}
			} catch (SQLException e){
				throw new ServletException(e);
			}


		}
	}

	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}

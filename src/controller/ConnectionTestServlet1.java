package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionTestServlet1
 */
@WebServlet("/ConnectionTestServlet1")
public class ConnectionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionTestServlet1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//ドライバをロード
			con = DriverManager.getConnection(//接続
				    //接続情報 //文字化け防止
					"jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf8",
					"root", "hiyuma5551");
			log("接続しました");
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
					log("切断しました");
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}

		}
	}
}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}

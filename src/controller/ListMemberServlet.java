package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.MemberDao;
import domain.Member;

/**
 * Servlet implementation class ListMemberServlet
 */
@WebServlet("/listMember")
public class ListMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListMemberServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*	練習9 コネクションオブジェクト取得
			Connection con = null;

			try {
				InitialContext ctx = new InitialContext();
				DataSource ds =
						(DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
				con = ds.getConnection(); //取得完了


				String sql = "SELECT * FROM members"; 練習9－2 //Membersデータを取得するSQL文

				String sql =
						"SELECT *,member_types.name AS type_name FROM members JOIN member_types ON members.type_id = member_types.id";

				PreparedStatement stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery(); //SELECT文の結果を取得

				List<Member> memberList = new ArrayList<>(); //空のリスト作成

				while(rs.next()) { //一件づつ取得

					Member member = new Member(); //空のインスタンス作成

					member.setId((Integer)rs.getObject("id"));
					member.setName(rs.getString("name"));
					member.setAge((Integer)rs.getObject("age"));
					member.setAddress(rs.getString("address"));
		//				member.setTypeId((Integer)rs.getObject("type_id")); 練習9-2
					member.setCreated(rs.getTimestamp("created"));
					member.setTypeName(rs.getString("type_name")); // 練習9-3 追加
					memberList.add(member);//最後にリストへ追加
				}
				request.setAttribute("memberList", memberList);
				request.getRequestDispatcher("/WEB-INF/view/listMember.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			} finally {
				try {
					if(con != null) {
						con.close();
					}
				} catch(SQLException e) {
					throw new ServletException(e);
				}*/

		try { /* 練習10－1 追加 */
			MemberDao memberDao = DaoFactory.createMemberDao();
			List<Member> memberList = memberDao.findAll();
			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/WEB-INF/view/listMember.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

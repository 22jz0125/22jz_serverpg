package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcSample
 */
@WebServlet("/JdbcSample")
public class JdbcSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CN_STRING = "jdbc:oracle:thin:@//10.40.112.11:1521/dbsys";
	private static final String USER =       "jz220125";
	private static final String PASS =       "passdayo";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			out.println("JDBCドライバのロードに失敗しました");
			return;
		}
		
		try(Connection cn = DriverManager.getConnection(CN_STRING, USER, PASS)) {

			String sql = "SELECT * FROM videos";
//			System.out.println(sql);
			PreparedStatement stmt = cn.prepareStatement(sql);
			
			System.out.println("SQL実行");
			ResultSet rs = stmt.executeQuery();
			
			out.println("<ul>");
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String synopsisShort = rs.getString("synopsis_short");
				String synopsisLong = rs.getString("synopsis_long");
				boolean pcNg = rs.getBoolean("pc_ng");
				
				out.println("<li>");
				out.println("ID:" + id + "<br>");
				out.println("タイトル:" + title + "<br>");
				out.println("紹介文（短）:" + synopsisShort + "<br>");
				out.println("紹介文（長）:" + synopsisLong + "<br>");
				out.println("PC不可フラグ:" + pcNg + "<br>");
				out.println("</li>");
			}
			out.println("</ul>");
		}catch(SQLException e) {
			out.println("SQLの実行に失敗しました");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

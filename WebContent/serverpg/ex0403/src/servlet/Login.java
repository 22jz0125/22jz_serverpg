package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogin = true;
		request.setAttribute("isLogin", isLogin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//Userインスタンス(ユーザー情報)の生成
		User user = new User(id, password);
		
		
		
		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);		
		
		//ログイン成功時
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("Top");
		}
		else {
			request.setAttribute("isLogin", isLogin);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}

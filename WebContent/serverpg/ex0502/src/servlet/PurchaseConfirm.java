package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

/**
 * Servlet implementation class PurchaseConfirm
 */
@WebServlet("/PurchaseConfirm")
public class PurchaseConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String paramCount = request.getParameter("count");	// count パラメータを取得 
		
		
		/* 取得したパラメータを int に変換 */
		int count = Integer.parseInt(paramCount);
		
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("item");
		
		request.setAttribute("item", item);
		request.setAttribute("count", count);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchaseConfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("NotFound/index.html");
	}

}

package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UranaiServlet
 */
@WebServlet("/Uranai")
public class Uranai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		int flg = 0;
		int fortune = -1;
		try {
			request.setCharacterEncoding("UTF-8");
			String parameta = request.getParameter("fortune");
			System.out.println(parameta);
			fortune = Integer.parseInt(parameta);
			if(Objects.isNull(fortune)) {
				flg = -1;
			}
		}
		catch(RuntimeException e) {
			flg = 2;
		}
		

		String luck;
		String[] luckArray = {"超すっきり", "すっきり", "まあまあすっきり", "最悪"};

		
		if(0 <= fortune && fortune <= 3 && flg == 0) {
			luck = luckArray[fortune];
		}
		else {
			int index = (int)(Math.random() * 4);
			luck = luckArray[index];
		}

		LocalDate nowDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd");
		String today = nowDate.format(format);
		
		request.setAttribute("luck", luck);
		request.setAttribute("today", today);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}

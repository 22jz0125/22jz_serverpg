package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UranaiServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
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
//		catch(NullPointerException e) {
//			flg = 1;
//		}
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
		
	//	response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>スッキリ占い</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + today + "の運勢は「" + luck + "」です</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

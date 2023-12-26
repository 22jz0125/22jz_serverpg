package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Item;

/**
 * Servlet implementation class ItemSearch
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Item item = new Item();
		
		try {
			String itemJson = mapper.writeValueAsString(item);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charaset=UTF-8");
			response.getWriter().write(itemJson);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		

	}

}

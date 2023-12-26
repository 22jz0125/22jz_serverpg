package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirm
 */
@WebServlet("/Confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		/* リクエストパラメータの文字コードをセット */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String paramCount = request.getParameter("count");	// count パラメータを取得 
		/* 取得したパラメータを int に変換 */
		int paramIntCount = Integer.parseInt(paramCount);
		
		// レスポンスデータの生成
		/* レスポンスデータの文字コードをセット */
		/* PrintWriter のインスタンスを取得 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>購入のご確認 | 仙台ふるさとプラザ</title>");
		out.println("<link rel=\"stylesheet\" href=\"../confirmation/assets/css/style.css\">");
		out.println("</head>");

		/* generateBody を呼び出して戻り値を画面に表示 */
		out.println(generateBody(paramIntCount));
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * HTML body を生成して返すメソッド
	 */
	private String generateBody(int count) {
		String body = "<body>";

		body += "<main>";
		body += "<h2>購入のご確認</h2>";
		body += "<ul class=\"purchase-list\">";
		body += "<li class=\"list-item\">";
		body += "<figure class=\"item-image\">";
		body += "<img src=\"../assets/img/saifu.png\" alt=\"革財布\" width=\"100\">";
		body += "</figure>";
		body += "<div class=\"list-item-description\">";
		body += "<p>革財布</p>";

		/* ここで数量と価格を表示 */
		body += "<p>" + count + "個</p>";
		body += "<p>" + (count * 26000) + "円</p>";

		body += "</div>";
		body += "</li>";
		body += "</ul>";
		body += "<form action=\"#\" method=\"GET\" class=\"form-purchase\">";
		body += "<p>上記の商品を購入します。よろしいですか？</p>";
		body += "<a href=\"/ex0303\" class=\"btn negative\">前のページへ戻る</a>";
		body += "<button type=\"button\" class=\"btn\">購入する</button>";
		body += "</form>";
		body += "</main>";
		
		
		body += "</body>";
		return body;
	}

}

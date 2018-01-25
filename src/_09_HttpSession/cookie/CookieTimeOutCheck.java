package _09_HttpSession.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cookietimeoutcheck", urlPatterns = { "/cookietimeoutcheck" })
public class CookieTimeOutCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		Cookie [] cookies=request.getCookies();
		
		if (cookies!=null) {
			for (Cookie c:cookies) {
				pw.println(c.getValue()+" "+c.getName());
			}
		} else {
				pw.print("not cookie");
		}
		
	}

}

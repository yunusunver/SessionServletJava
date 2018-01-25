package _09_HttpSession.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cookietimeout", urlPatterns = { "/cookietimeout" })
public class CookieTimeOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie cookie=new Cookie("username","yunus");
		cookie.setMaxAge(10); // 10 saniye sonra cookie'yi siler
		response.addCookie(cookie);
		
		String contextPath=request.getContextPath();
		
		String url=contextPath+"/cookietimeoutcheck";//sayfaya yönlendirir
		
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body>");
		pw.println("<a href=\""+url+"\"> Click here</a>.");
		
	}

}

package _09_HttpSession.more;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "moresessionmethods", urlPatterns = { "/moresessionmethods" })
public class MoreSessionMethods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String heading;
		Integer accessCount=(Integer)session.getAttribute("accessCount");
		
		//session boþsa 0 deðeri atanýyor deðilse deðeri 1 artýrýlýyor.
		if (accessCount==null) {
			accessCount=0;
		}
		else {
			accessCount++;
		}
		
		
		session.setAttribute("accessCount", accessCount);
		
		//session id bilgisini döndürür
		String id=session.getId();
		//sessionun oluþturulma tarihini döndürür
		Date creationTime=new Date(session.getCreationTime());
		//istemcinin en son istek gönderdiði zamana döndürür
		Date lastAccessedTime=new Date(session.getLastAccessedTime());
		//sessionun timeout(yaþama süresini) süresini döndürür
		Integer maxInactiveInternal=session.getMaxInactiveInterval();
		
		PrintWriter pw=response.getWriter();
		
		//html kodlarýnýn olduðu yer.Tablo oluþturarak içine  session bilgilerini yazdýrýyoruz.
		pw.print("<html><body><table>");
		pw.print("<tr><td>Session</td>");
		pw.print("<td>"+id+"</td></tr>");
		pw.print("<tr><td>Creation Time</td>");
		pw.print("<td></td>"+creationTime+"</td></tr>");
		pw.print("<tr><td>Last Accessed Time</td>");
		pw.print("<td></td>"+lastAccessedTime+"</td></tr>");
		pw.print("<tr><td>Max Inactive Internal</td>");
		pw.print("<td></td>"+maxInactiveInternal+"</td></tr>");
		pw.print("<tr><td>Access Count</td>");
		pw.print("<td>" + accessCount + "</td></tr>");
		pw.print("</table></body></html>");
	}

}

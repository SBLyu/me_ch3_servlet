package mad.nthu.ch3_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	private String getOS(String userAgent){
		if(userAgent.indexOf("NT 6.1")>0) return "Windows 7";
		if(userAgent.indexOf("NT 6.2")>0) return "Windows 8";
		if(userAgent.indexOf("NT 6.3")>0) return "Windows 8.1";
		if(userAgent.indexOf("NT 10.0")>0) return "Windows 10";
		if(userAgent.indexOf("Linux")>0) return "Linux";
		return "未知作業系統";
	}
	
	private String getNavigator(String userAgent){
		if(userAgent.indexOf("Chrome")>0) return "Chrome瀏覽器";
		if(userAgent.indexOf("Firefox")>0) return "Firefox瀏覽器";
		if(userAgent.indexOf("MSIE")>0) return "IE瀏覽器";
		return "未知瀏覽器";
	}
	private String getLocale(Locale userLocale){
		if(Locale.SIMPLIFIED_CHINESE.equals(userLocale)) return "簡體中文";
		if(Locale.TRADITIONAL_CHINESE.equals(userLocale)) return "繁體中文";
		if(Locale.ENGLISH.equals(userLocale)) return "英文";
		if(Locale.JAPANESE.equals(userLocale)) return "日文";
		return "未知語言環境";
	}
	
	
	
	
	public RequestServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String userAgent=request.getHeader("user-agent");
		Locale userLocale=request.getLocale();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		out.println("<b>IP為</b>"+request.getRemoteAddr()+"<br/>");
		out.println("<b>您使用</b>"+getOS(userAgent)+"<b>作業系統</b>"+"<br/>");
		out.println("<b>您使用</b>"+getNavigator(userAgent)+"<br/>");
		out.println("<b>您使用</b>"+getLocale(userLocale)+"<br/>");
		
		out.println("<b>伺服器IP: </b>"+request.getLocalAddr()+"<br/>");
		out.println("<b>伺服器使用的通訊埠: </b>"+request.getServerPort()+"<b>通訊埠</b><br/>");
		out.println("<b>伺服器軟體: </b>"+this.getServletContext().getServerInfo()+"<br/>");
		out.println("<b>伺服器名稱: </b>"+request.getLocalName()+"<br/>");
		out.println("<b>伺服器使用協定: </b>"+request.getProtocol()+"<br/>");
		out.println("<b>存取的URI: </b>"+request.getRequestURI()+"<br/>");
		
		out.println("<b>Servlet路徑: </b>"+request.getServletPath()+"<br/>");
		out.println("<b>Servlet類別名稱: </b>"+this.getClass().getName()+"<br/>");
		out.println("<b>程式在硬碟的跟目錄: </b>"+this.getServletContext().getRealPath("")+"<br/>");
		out.println("<b>網路相對路徑: </b>"+request.getContextPath()+"<br/>");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}

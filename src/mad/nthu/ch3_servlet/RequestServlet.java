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
		return "�����@�~�t��";
	}
	
	private String getNavigator(String userAgent){
		if(userAgent.indexOf("Chrome")>0) return "Chrome�s����";
		if(userAgent.indexOf("Firefox")>0) return "Firefox�s����";
		if(userAgent.indexOf("MSIE")>0) return "IE�s����";
		return "�����s����";
	}
	private String getLocale(Locale userLocale){
		if(Locale.SIMPLIFIED_CHINESE.equals(userLocale)) return "²�餤��";
		if(Locale.TRADITIONAL_CHINESE.equals(userLocale)) return "�c�餤��";
		if(Locale.ENGLISH.equals(userLocale)) return "�^��";
		if(Locale.JAPANESE.equals(userLocale)) return "���";
		return "�����y������";
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
		
		out.println("<b>IP��</b>"+request.getRemoteAddr()+"<br/>");
		out.println("<b>�z�ϥ�</b>"+getOS(userAgent)+"<b>�@�~�t��</b>"+"<br/>");
		out.println("<b>�z�ϥ�</b>"+getNavigator(userAgent)+"<br/>");
		out.println("<b>�z�ϥ�</b>"+getLocale(userLocale)+"<br/>");
		
		out.println("<b>���A��IP: </b>"+request.getLocalAddr()+"<br/>");
		out.println("<b>���A���ϥΪ��q�T��: </b>"+request.getServerPort()+"<b>�q�T��</b><br/>");
		out.println("<b>���A���n��: </b>"+this.getServletContext().getServerInfo()+"<br/>");
		out.println("<b>���A���W��: </b>"+request.getLocalName()+"<br/>");
		out.println("<b>���A���ϥΨ�w: </b>"+request.getProtocol()+"<br/>");
		out.println("<b>�s����URI: </b>"+request.getRequestURI()+"<br/>");
		
		out.println("<b>Servlet���|: </b>"+request.getServletPath()+"<br/>");
		out.println("<b>Servlet���O�W��: </b>"+this.getClass().getName()+"<br/>");
		out.println("<b>�{���b�w�Ъ���ؿ�: </b>"+this.getServletContext().getRealPath("")+"<br/>");
		out.println("<b>�����۹���|: </b>"+request.getContextPath()+"<br/>");
		
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

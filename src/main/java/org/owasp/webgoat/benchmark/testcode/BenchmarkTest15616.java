package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15616")
public class BenchmarkTest15616 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21556 = param; //assign
		StringBuilder b21556 = new StringBuilder(a21556);  // stick in stringbuilder
		b21556.append(" SafeStuff"); // append some safe content
		b21556.replace(b21556.length()-"Chars".length(),b21556.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21556 = new java.util.HashMap<String,Object>();
		map21556.put("key21556", b21556.toString()); // put in a collection
		String c21556 = (String)map21556.get("key21556"); // get it back out
		String d21556 = c21556.substring(0,c21556.length()-1); // extract most of it
		String e21556 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21556.getBytes() ) )); // B64 encode and decode it
		String f21556 = e21556.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g21556 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21556); // reflection
	
		return bar;	
	}
}
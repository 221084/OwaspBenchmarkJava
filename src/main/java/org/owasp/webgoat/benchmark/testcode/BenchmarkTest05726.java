package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05726")
public class BenchmarkTest05726 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a9165 = param; //assign
		StringBuilder b9165 = new StringBuilder(a9165);  // stick in stringbuilder
		b9165.append(" SafeStuff"); // append some safe content
		b9165.replace(b9165.length()-"Chars".length(),b9165.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9165 = new java.util.HashMap<String,Object>();
		map9165.put("key9165", b9165.toString()); // put in a collection
		String c9165 = (String)map9165.get("key9165"); // get it back out
		String d9165 = c9165.substring(0,c9165.length()-1); // extract most of it
		String e9165 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9165.getBytes() ) )); // B64 encode and decode it
		String f9165 = e9165.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9165); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}
}
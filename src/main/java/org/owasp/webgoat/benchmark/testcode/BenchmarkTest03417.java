package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03417")
public class BenchmarkTest03417 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a87449 = param; //assign
		StringBuilder b87449 = new StringBuilder(a87449);  // stick in stringbuilder
		b87449.append(" SafeStuff"); // append some safe content
		b87449.replace(b87449.length()-"Chars".length(),b87449.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87449 = new java.util.HashMap<String,Object>();
		map87449.put("key87449", b87449.toString()); // put in a collection
		String c87449 = (String)map87449.get("key87449"); // get it back out
		String d87449 = c87449.substring(0,c87449.length()-1); // extract most of it
		String e87449 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87449.getBytes() ) )); // B64 encode and decode it
		String f87449 = e87449.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87449); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, new int[] { 1, 2 } );
			statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
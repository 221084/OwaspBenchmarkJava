package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12341")
public class BenchmarkTest12341 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		// Create the file first so the test won't throw an exception if it doesn't exist.
		// Note: Don't actually do this because this method signature could cause a tool to find THIS file constructor 
		// as a vuln, rather than the File signature we are trying to actually test.
		// If necessary, just run the benchmark twice. The 1st run should create all the necessary files.
		//new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar).createNewFile();
		


        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
        		org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
        java.io.FileDescriptor fd = fileInputStream.getFD();
        java.io.FileOutputStream anotOutputStream = new java.io.FileOutputStream(fd);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53627 = param; //assign
		StringBuilder b53627 = new StringBuilder(a53627);  // stick in stringbuilder
		b53627.append(" SafeStuff"); // append some safe content
		b53627.replace(b53627.length()-"Chars".length(),b53627.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53627 = new java.util.HashMap<String,Object>();
		map53627.put("key53627", b53627.toString()); // put in a collection
		String c53627 = (String)map53627.get("key53627"); // get it back out
		String d53627 = c53627.substring(0,c53627.length()-1); // extract most of it
		String e53627 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53627.getBytes() ) )); // B64 encode and decode it
		String f53627 = e53627.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f53627); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
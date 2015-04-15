package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13633")
public class BenchmarkTest13633 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map40135 = new java.util.HashMap<String,Object>();
		map40135.put("keyA-40135", "a_Value"); // put some stuff in the collection
		map40135.put("keyB-40135", param.toString()); // put it in a collection
		map40135.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map40135.get("keyB-40135"); // get it back out
		bar = (String)map40135.get("keyA-40135"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
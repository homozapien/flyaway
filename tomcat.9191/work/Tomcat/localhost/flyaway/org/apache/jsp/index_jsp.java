/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.20
 * Generated at: 2022-07-08 09:10:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/login.jsp", Long.valueOf(1657053848451L));
    _jspx_dependants.put("/mybootstrap.jsp", Long.valueOf(1655930670806L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.min.css\" />\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.min.css\" />\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"container\">\n");
      out.write("\n");
      out.write("		<h2>Flyaway Login Portal</h2>\n");
      out.write("		<div class=\"card\">\n");
      out.write("			<div class=\"card-body\">\n");
      out.write("				<form action=\"LoginController\" method=\"post\">\n");
      out.write("\n");
      out.write("					<div class=\"row mb-3\">\n");
      out.write("\n");
      out.write("						<label for=\"email\" class=\"col-sm-2 col-form-label\">Email</label>\n");
      out.write("\n");
      out.write("						<div class=\"col-sm-10\">\n");
      out.write("							<input type=\"email\" class=\"form-control\" name=\"email\"\n");
      out.write("								placeholder=\"Enter Login Email\" />\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"row mb-3\">\n");
      out.write("						<label for=\"password\" class=\"col-sm-2 col-form-label\">Password</label>\n");
      out.write("\n");
      out.write("						<div class=\"col-sm-10\">\n");
      out.write("							<input type=\"password\" name=\"password\"\n");
      out.write("								placeholder=\"Enter password\" />\n");
      out.write("\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<fieldset class=\"row mb-3\">\n");
      out.write("					\n");
      out.write("                       <legend class=\"col-form-label col-sm-2 pt-0\">User Type</legend>	\n");
      out.write("\n");
      out.write("						<div class=\"col-sm-10\">\n");
      out.write("\n");
      out.write("							<div class=\"form-check\">							\n");
      out.write("									 <label class=\"form-check-label\">\n");
      out.write("									     <input class=\"form-check-input\" type=\"radio\" name=\"typeOfUser\" id=\"adminRadioBttn\" value=\"Admin\">Administrator 	\n");
      out.write("									</label> \n");
      out.write("								</div>	\n");
      out.write("								<div class=\"form-check\">\n");
      out.write("									<label class=\"form-check-label\">\n");
      out.write("									     <input class=\"form-check-input\" type=\"radio\" name=\"typeOfUser\" id=\"custRadioBttn\" value=\"Customer\">Customer 	\n");
      out.write("									</label>\n");
      out.write("							</div>\n");
      out.write("						</div>\n");
      out.write("					</fieldset>\n");
      out.write("					\n");
      out.write("					<hr>\n");
      out.write("                \n");
      out.write("                   <label class=\"col-sm-2 col-form-label\"></label>               \n");
      out.write("                               \n");
      out.write("					<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("					<input class=\"btn btn-secondary\" type=\"reset\" value=\"Reset\">\n");
      out.write("					\n");
      out.write("				</form>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
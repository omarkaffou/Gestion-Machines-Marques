package org.apache.jsp.oldTem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!-- Content Row -->\n");
      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("\n");
      out.write("    <!-- Area Chart -->\n");
      out.write("    <div class=\"col-xl-8 col-lg-7\">\n");
      out.write("        <div class=\"card shadow mb-4\">\n");
      out.write("            <!-- Card Header - Dropdown -->\n");
      out.write("            <div\n");
      out.write("                class=\"card-header py-3 d-flex flex-row align-items-center justify-content-between\">\n");
      out.write("                <h6 class=\"m-0 font-weight-bold text-primary\">Nombre de machine par marque</h6>\n");
      out.write("                <div class=\"dropdown no-arrow\">\n");
      out.write("                    <a class=\"dropdown-toggle\" href=\"#\" role=\"button\" id=\"dropdownMenuLink\"\n");
      out.write("                       data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        <i class=\"fas fa-ellipsis-v fa-sm fa-fw text-gray-400\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right shadow animated--fade-in\"\n");
      out.write("                         aria-labelledby=\"dropdownMenuLink\">\n");
      out.write("                        <div class=\"dropdown-header\">Dropdown Header:</div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Action</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Another action</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Card Body -->\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <div class=\"chart-bar\">\n");
      out.write("                    <canvas id=\"myBarChart\"></canvas>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Pie Chart -->\n");
      out.write("\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

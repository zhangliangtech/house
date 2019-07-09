/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-07-07 09:03:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class street_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>街道</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"easyUI/themes/bootstrap/easyui.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"easyUI/themes/icon.css\"/>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-1.8.3.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"easyUI/css/demo.css\">\r\n");
      out.write("    <script language=\"JavaScript\" src=\"js/street.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table id=\"showStreets\"></table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"rudToolBar\">\r\n");
      out.write("    <a href=\"javascript:addButton()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">添加</a>\r\n");
      out.write("    <a href=\"javascript:updateButton()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">修改</a>\r\n");
      out.write("    <a href=\"javascript:deleteStreets()\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\">删除</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"addDialog\" buttons=\"#addButtons\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <form id=\"addSubmit\" method=\"post\">\r\n");
      out.write("        <table align=\"center\" style=\"margin-top: 10px\" cellspacing=\"20px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>所属区域:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input id=\"adddistrictId\"  name=\"districtId\" value=\"--请选择所属区域--\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>街道名称:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"text\" class=\"easyui-validatebox\" required name=\"name\" />\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div id=\"addButtons\" align=\"center\" style=\"padding-right: 100px\">\r\n");
      out.write("        <a href=\"javascript:addSaveStreet()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a>\r\n");
      out.write("        <a href=\"javascript:closeDialog('addDialog')\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">取消</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"updateDialog\" buttons=\"#updateButtons\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <form id=\"updateSubmit\" method=\"post\">\r\n");
      out.write("        <table align=\"center\" style=\"margin-top: 50px\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>所属区域:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input id=\"updatedistrictId\"  name=\"districtId\" value=\"--请选择所属区域--\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("            <td>街道名称:</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <input type=\"text\" class=\"easyui-validatebox\" required name=\"name\"/>\r\n");
      out.write("                <input type=\"hidden\" class=\"easyui-validatebox\" required name=\"id\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div id=\"updateButtons\" align=\"center\" style=\"padding-right: 100px\">\r\n");
      out.write("        <a href=\"javascript:updateSaveStreet()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a>\r\n");
      out.write("        <a href=\"javascript:closeDialog('updateDialog')\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">取消</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

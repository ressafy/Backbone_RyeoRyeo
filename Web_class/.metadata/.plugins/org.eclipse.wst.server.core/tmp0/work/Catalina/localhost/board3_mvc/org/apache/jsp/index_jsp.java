/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-22 01:08:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1663554308029L));
    _jspx_dependants.put("jar:file:/C:/0_SSAFY/2_workspace/1_java/Backbone_RyeoRyeo/Web_class/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/board3_mvc/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write(' ');
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    />\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/app.css\" rel=\"stylesheet\" />\n");
      out.write("    <title>SSAFY</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row justify-content-center\">\n");
      out.write("        <div class=\"col-lg-8 col-md-10 col-sm-12\">\n");
      out.write("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">\n");
      out.write("            <mark class=\"orange\">로그인</mark>\n");
      out.write("          </h2>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-8 col-md-10 col-sm-12\">\n");
      out.write("          <form id=\"form-login\" method=\"POST\" action=\"\">\n");
      out.write("\n");
      out.write("            <div class=\"form-check mb-3 float-end\">\n");
      out.write("              <input\n");
      out.write("                class=\"form-check-input\"\n");
      out.write("                type=\"checkbox\"\n");
      out.write("                value=\"ok\"\n");
      out.write("                id=\"saveid\"\n");
      out.write("                name=\"saveid\"\n");
      out.write("              />\n");
      out.write("              <label class=\"form-check-label\" for=\"saveid\"> 아이디저장 </label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"userid\" class=\"form-label\">아이디 : </label>\n");
      out.write("              <input\n");
      out.write("                type=\"text\"\n");
      out.write("                class=\"form-control\"\n");
      out.write("                id=\"userid\"\n");
      out.write("                name=\"userid\"\n");
      out.write("                placeholder=\"아이디...\"\n");
      out.write("              />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("              <label for=\"userpwd\" class=\"form-label\">비밀번호 : </label>\n");
      out.write("              <input\n");
      out.write("                type=\"password\"\n");
      out.write("                class=\"form-control\"\n");
      out.write("                id=\"userpwd\"\n");
      out.write("                name=\"userpwd\"\n");
      out.write("                placeholder=\"비밀번호...\"\n");
      out.write("              />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-danger mb-2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("            <div class=\"col-auto text-center\">\n");
      out.write("              <button type=\"button\" id=\"btn-login\" class=\"btn btn-outline-primary mb-3\">\n");
      out.write("                로그인\n");
      out.write("              </button>\n");
      out.write("              <button type=\"button\" id=\"btn-mv-join\" class=\"btn btn-outline-success mb-3\">\n");
      out.write("                회원가입\n");
      out.write("              </button>\n");
      out.write("            </div>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <script\n");
      out.write("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("      integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\n");
      out.write("      crossorigin=\"anonymous\"\n");
      out.write("    ></script>\n");
      out.write("    <script>\n");
      out.write("	  // 회원가입 페이지 이동.    \n");
      out.write("      document.querySelector(\"#btn-mv-join\").addEventListener(\"click\", function () {\n");
      out.write("    	location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/user?act=mvjoin\";\n");
      out.write("      });\n");
      out.write("      \n");
      out.write("	  // 로그인\n");
      out.write("      document.querySelector(\"#btn-login\").addEventListener(\"click\", function () {\n");
      out.write("        if (!document.querySelector(\"#userid\").value) {\n");
      out.write("          alert(\"아이디 입력!!\");\n");
      out.write("          return;\n");
      out.write("        } else if (!document.querySelector(\"#userpwd\").value) {\n");
      out.write("          alert(\"비밀번호 입력!!\");\n");
      out.write("          return;\n");
      out.write("        } else {\n");
      out.write("          let form = document.querySelector(\"#form-login\");\n");
      out.write("          form.setAttribute(\"action\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/user\");\n");
      out.write("          form.submit();\n");
      out.write("        }\n");
      out.write("      });\n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("      <div class=\"row justify-content-center\">\n");
      out.write("        <div class=\"col-lg-8 col-md-10 col-sm-12\">\n");
      out.write("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">\n");
      out.write("            <mark class=\"orange\">SSAFY 게시판 - MVC Pattern</mark>\n");
      out.write("          </h2>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-8 col-md-10 col-sm-12 text-center\">\n");
      out.write("          <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board\">글쓰기</a><br />\n");
      out.write("          <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${root}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board\">글목록</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /index.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("root");
      // /index.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/index.jsp(3,0) '${pageContext.request.contextPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}

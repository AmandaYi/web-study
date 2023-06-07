import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.printf("name = %s; password = %s", name, password);
//        response.setHeader("A", "AAA");

        String html = "";

        if("admin".equals(name) && "123456".equals(password)) {
            html = "success 成功了";
        }else{
            html = "fail";
        }

        PrintWriter pw = response.getWriter();
        pw.println(html);

    }
}
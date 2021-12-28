package servlets;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        UserDao userDao=new UserDao();
        if (req.getParameter("user")!=null && req.getParameter("password")!=null){
            User user=userDao.getUser(req.getParameter("user"),req.getParameter("password"));
            if(user!=null){
                req.getRequestDispatcher("/welcome").forward(req,resp);

            }else {
                req.getRequestDispatcher("welcom.html").include(req,resp);
                writer.print("===>>> Error ");
            }
        }

    }
}

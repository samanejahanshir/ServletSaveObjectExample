package servlets;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        User user=new User();
       String name=req.getParameter("user");
       String pass=req.getParameter("password");
       String email=req.getParameter("password");
        if(name!=null && name!="" && pass!=null && pass!="" && email!=null && email!=""){
            user.setUserName(req.getParameter("user"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            UserDao userDao=new UserDao();
            userDao.saveUser(user);
            req.getRequestDispatcher("/welcome").forward(req,resp);
        }else {
            writer.print("==>> fill all field please");
        }
    }
}

package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "DeleteDisciplineController",urlPatterns = "/discipline-delete")
public class DeleteDisciplineController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String deleteDisciplineHidden = req.getParameter("deleteDisciplineHidden");
       String[] ids = deleteDisciplineHidden.split("-");
       for(String id:ids){
           DBManager.deleteDiscipline(id);
       }
        resp.sendRedirect("/disciplines");
    }
}

package controllers;

import db.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet (name = "TermsControllers", urlPatterns = "/terms")
public class TermsControllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idSelectedTerm = req.getParameter("idSelectedTerm");
        List<Term> terms = DBManager.getAllActiveTerms();
        req.setAttribute("terms",terms);

        Term selectedTerm = null;
        if(idSelectedTerm != null){// отработает, если пользователь нажал на кнопку ВЫБРАТЬ
            selectedTerm = DBManager.getTermById(idSelectedTerm) ;

        }else {

            if(terms.size() != 0){
                selectedTerm = terms.get(0);
            }
        }

        req.setAttribute("SelectedTerm", selectedTerm);






        req.getRequestDispatcher("WEB-INF/terms.jsp").forward(req,resp);
    }
}

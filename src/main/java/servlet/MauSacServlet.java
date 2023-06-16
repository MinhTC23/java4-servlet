package servlet;

import entity.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.MauSacRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {"/mau-sac/hien-thi"
        , "/mau-sac/add"
        , "/mau-sac/update"
        , "/mau-sac/delete"
        , "/mau-sac/detail"
})
public class MauSacServlet extends HttpServlet {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<MauSac> mauSacs = mauSacRepository.getAll();
            request.setAttribute("list", mauSacs);
            request.getRequestDispatcher("/view/MauSac.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            MauSac ms = mauSacRepository.detail(new MauSac(id));
            request.setAttribute("ms", ms);
            request.getRequestDispatcher("/view/MauSacViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            MauSac ms = new MauSac(id);
            mauSacRepository.deleteMauSac(ms);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            MauSac ms = new MauSac(ma, ten);

            mauSacRepository.addMauSac(ms);

            response.sendRedirect("/mau-sac/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            MauSac ms = new MauSac(id, ma, ten);

            mauSacRepository.updateMauSac(ms);

            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}

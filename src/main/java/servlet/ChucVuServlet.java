package servlet;

import entity.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChucVuRepository;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "ChucVuServlet", value = {"/chuc-vu/hien-thi"
        , "/chuc-vu/add"
        , "/chuc-vu/update"
        , "/chuc-vu/delete"
        , "/chuc-vu/detail"
})
public class ChucVuServlet extends HttpServlet {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<ChucVu> chucVus = chucVuRepository.getAll();
            request.setAttribute("list", chucVus);
            request.getRequestDispatcher("/view/ChucVu.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            ChucVu cv = chucVuRepository.detail(new ChucVu(id));
            request.setAttribute("cv", cv);
            request.getRequestDispatcher("/view/ChucVuViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            ChucVu cv = new ChucVu(id);
            chucVuRepository.deleteChucVu(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu cv = new ChucVu(ma, ten);

            chucVuRepository.addChucVu(cv);

            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu cv = new ChucVu(id, ma, ten);

            chucVuRepository.updateChucVu(cv);

            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}

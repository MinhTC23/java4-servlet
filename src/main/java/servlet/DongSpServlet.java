package servlet;

import entity.DongSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.DongSpRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DongSpServlet", value = {"/dong-san-pham/hien-thi"
        , "/dong-san-pham/add"
        , "/dong-san-pham/update"
        , "/dong-san-pham/delete"
        , "/dong-san-pham/detail"
})
public class DongSpServlet extends HttpServlet {

    private DongSpRepository dongSpRepository = new DongSpRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<DongSP> dongSps = dongSpRepository.getAll();
            request.setAttribute("list", dongSps);
            request.getRequestDispatcher("/view/DongSanPham.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            DongSP dsp = dongSpRepository.detail(new DongSP(id));
            request.setAttribute("dsp", dsp);
            request.getRequestDispatcher("/view/DongSanPhamViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            DongSP dsp = new DongSP(id);
            dongSpRepository.deleteDongSP(dsp);
            response.sendRedirect("/dong-san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSP dsp = new DongSP(ma, ten);

            dongSpRepository.addDongSP(dsp);

            response.sendRedirect("/dong-san-pham/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSP dsp = new DongSP(id, ma, ten);

            dongSpRepository.updateDongSP(dsp);

            response.sendRedirect("/dong-san-pham/hien-thi");
        }
    }
}

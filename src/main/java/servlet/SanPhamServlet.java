package servlet;

import entity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.SanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi"
        , "/san-pham/add"
        , "/san-pham/update"
        , "/san-pham/delete"
        , "/san-pham/detail"
})
public class SanPhamServlet extends HttpServlet {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<SanPham> sanPhams = sanPhamRepository.getAll();
            request.setAttribute("list", sanPhams);
            request.getRequestDispatcher("/view/SanPham.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            SanPham sp = sanPhamRepository.detail(new SanPham(id));
            request.setAttribute("sp", sp);
            request.getRequestDispatcher("/view/SanPhamViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            SanPham sp = new SanPham(id);
            sanPhamRepository.deleteSanPham(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            SanPham sp = new SanPham(ma, ten);

            sanPhamRepository.addSanPham(sp);

            response.sendRedirect("/san-pham/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            SanPham sp = new SanPham(id, ma, ten);

            sanPhamRepository.updateSanPham(sp);

            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}

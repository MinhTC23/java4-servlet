package servlet;

import entity.NSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NsxRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NsxServlet", value = {"/nha-san-xuat/hien-thi"
        , "/nha-san-xuat/add"
        , "/nha-san-xuat/update"
        , "/nha-san-xuat/delete"
        , "/nha-san-xuat/detail"
})
public class NsxServlet extends HttpServlet {

    private NsxRepository nsxRepository = new NsxRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<NSX> nsxs = nsxRepository.getAll();
            request.setAttribute("list", nsxs);
            request.getRequestDispatcher("/view/NhaSanXuat.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            NSX nsx = nsxRepository.detail(new NSX(id));
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/NhaSanXuatViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            NSX nsx = new NSX(id);
            nsxRepository.deleteNSX(nsx);
            response.sendRedirect("/nha-san-xuat/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            NSX nsx = new NSX(ma, ten);

            nsxRepository.addNSX(nsx);

            response.sendRedirect("/nha-san-xuat/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            NSX nsx = new NSX(id, ma, ten);

            nsxRepository.updateNSX(nsx);

            response.sendRedirect("/nha-san-xuat/hien-thi");
        }
    }
}

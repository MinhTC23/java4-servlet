package servlet;

import entity.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.CuaHangRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CuaHangServlet", value = {"/cua-hang/hien-thi"
        , "/cua-hang/add"
        , "/cua-hang/update"
        , "/cua-hang/delete"
        , "/cua-hang/detail"
})
public class CuaHangServlet extends HttpServlet {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<CuaHang> cuaHangs = cuaHangRepository.getAll();
            request.setAttribute("list", cuaHangs);
            request.getRequestDispatcher("/view/CuaHang.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            CuaHang ch = cuaHangRepository.detail(new CuaHang(id));
            request.setAttribute("ch", ch);
            request.getRequestDispatcher("/view/CuaHangViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            CuaHang ch = new CuaHang(id);
            cuaHangRepository.deleteCuaHang(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang ch = new CuaHang(ma, ten, diaChi, thanhPho, quocGia);

            cuaHangRepository.addCuaHang(ch);

            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");

            CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);

            cuaHangRepository.updateCuaHang(ch);

            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}

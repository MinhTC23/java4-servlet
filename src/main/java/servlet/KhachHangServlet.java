package servlet;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.KhachHangRepository;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi"
        , "/khach-hang/add"
        , "/khach-hang/update"
        , "/khach-hang/delete"
        , "/khach-hang/detail"
})
public class KhachHangServlet extends HttpServlet {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<KhachHang> khachHangs = khachHangRepository.getAll();
            request.setAttribute("list", khachHangs);
            request.getRequestDispatcher("/view/KhachHang.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            String id = request.getParameter("id");
            KhachHang kh = khachHangRepository.detail(new KhachHang(id));
            String ngaySinh = format.format(kh.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("kh", kh);
            request.getRequestDispatcher("/view/KhachHangViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            KhachHang kh = new KhachHang(id);
            khachHangRepository.deleteKhachHang(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");

            KhachHang kh = new KhachHang(ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);

            khachHangRepository.addKhachHang(kh);

            response.sendRedirect("/khach-hang/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");

            KhachHang kh = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);

            khachHangRepository.updateKhachHang(kh);

            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}

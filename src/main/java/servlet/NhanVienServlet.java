package servlet;

import entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi"
        , "/nhan-vien/add"
        , "/nhan-vien/update"
        , "/nhan-vien/delete"
        , "/nhan-vien/detail"
})
public class NhanVienServlet extends HttpServlet {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<CuaHang> cuaHangs = cuaHangRepository.getAll();
            ArrayList<ChucVu> chucVus = chucVuRepository.getAll();
            ArrayList<NhanVien> nhanViens = nhanVienRepository.getAll();
            request.setAttribute("cuaHangs", cuaHangs);
            request.setAttribute("chucVus", chucVus);
            request.setAttribute("list", nhanViens);
            request.getRequestDispatcher("/view/NhanVien.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            ArrayList<CuaHang> cuaHangs = cuaHangRepository.getAll();
            ArrayList<ChucVu> chucVus = chucVuRepository.getAll();
            request.setAttribute("cuaHangs", cuaHangs);
            request.setAttribute("chucVus", chucVus);
            String id = request.getParameter("id");
            NhanVien nv = nhanVienRepository.detail(new NhanVien(id));
            String ngaySinh = dateFormat.format(nv.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("nv", nv);
            request.getRequestDispatcher("/view/NhanVienViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            NhanVien nv = new NhanVien(id);
            nhanVienRepository.deleteNhanVien(nv);
            response.sendRedirect("/nhan-vien/hien-thi");
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
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String idCH = request.getParameter("idCH");
            CuaHang cuaHang = new CuaHang(idCH);
            String idCV = request.getParameter("idCV");
            ChucVu chucVu = new ChucVu(idCV);
            String idGuiBC = null;
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nv = new NhanVien(ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, idGuiBC, trangThai);

            nhanVienRepository.addNhanVien(nv);

            response.sendRedirect("/nhan-vien/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String idCH = request.getParameter("idCH");
            CuaHang cuaHang = new CuaHang(idCH);
            String idCV = request.getParameter("idCV");
            ChucVu chucVu = new ChucVu(idCV);
            String idGuiBC = null;
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));

            NhanVien nv = new NhanVien(id, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, idGuiBC, trangThai);

            nhanVienRepository.updateNhanVien(nv);

            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}

package servlet;

import entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet(name = "ChiTietSanPhamServlet", value = {"/chi-tiet-san-pham/hien-thi"
        , "/chi-tiet-san-pham/add"
        , "/chi-tiet-san-pham/update"
        , "/chi-tiet-san-pham/delete"
        , "/chi-tiet-san-pham/detail"
})
public class ChiTietSanPhamServlet extends HttpServlet {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private NsxRepository nsxRepository = new NsxRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private DongSpRepository dongSpRepository = new DongSpRepository();
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<SanPham> sanPhams = sanPhamRepository.getAll();
            ArrayList<NSX> nsxs = nsxRepository.getAll();
            ArrayList<MauSac> mauSacs = mauSacRepository.getAll();
            ArrayList<DongSP> dongSPs = dongSpRepository.getAll();
            ArrayList<ChiTietSP> chiTietSPs = chiTietSanPhamRepository.getAll();
            request.setAttribute("sanPhams", sanPhams);
            request.setAttribute("nsxs", nsxs);
            request.setAttribute("mauSacs", mauSacs);
            request.setAttribute("dongSPs", dongSPs);
            request.setAttribute("chiTietSPs", chiTietSPs);
            request.getRequestDispatcher("/view/ChiTietSanPham.jsp").forward(request, response);
        } else if(uri.contains("detail")){
            ArrayList<SanPham> sanPhams = sanPhamRepository.getAll();
            ArrayList<NSX> nsxs = nsxRepository.getAll();
            ArrayList<MauSac> mauSacs = mauSacRepository.getAll();
            ArrayList<DongSP> dongSPs = dongSpRepository.getAll();
            request.setAttribute("sanPhams", sanPhams);
            request.setAttribute("nsxs", nsxs);
            request.setAttribute("mauSacs", mauSacs);
            request.setAttribute("dongSPs", dongSPs);
            request.setAttribute("mauSacs", mauSacs);
            String id = request.getParameter("id");
            ChiTietSP ctsp = chiTietSanPhamRepository.detail(new ChiTietSP(id));
            request.setAttribute("ctsp", ctsp);
            request.getRequestDispatcher("/view/ChiTietSanPhamViewUpdate.jsp").forward(request, response);
        } else if(uri.contains("delete")){
            String id = request.getParameter("id");
            ChiTietSP chiTietSP = new ChiTietSP(id);
            chiTietSanPhamRepository.deleteChiTietSP(chiTietSP);
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String idSP = request.getParameter("idSP");
            SanPham sanPham = new SanPham(idSP);
            String idNsx = request.getParameter("idNsx");
            NSX nsx = new NSX(idNsx);
            String idMauSac = request.getParameter("idMauSac");
            MauSac mauSac = new MauSac(idMauSac);
            String idDongSP = request.getParameter("idDongSP");
            DongSP dongSP = new DongSP(idDongSP);
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap = BigDecimal.valueOf(Long.valueOf(request.getParameter("giaNhap")));
            BigDecimal giaBan = BigDecimal.valueOf(Long.valueOf(request.getParameter("giaBan")));

            ChiTietSP chiTietSP = new ChiTietSP(sanPham, nsx, mauSac, dongSP, namBH, moTa, soLuongTon, giaNhap, giaBan);

            chiTietSanPhamRepository.addChiTietSP(chiTietSP);

            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String idSP = request.getParameter("idSP");
            SanPham sanPham = new SanPham(idSP);
            String idNsx = request.getParameter("idNsx");
            NSX nsx = new NSX(idNsx);
            String idMauSac = request.getParameter("idMauSac");
            MauSac mauSac = new MauSac(idMauSac);
            String idDongSP = request.getParameter("idDongSP");
            DongSP dongSP = new DongSP(idDongSP);
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap = BigDecimal.valueOf(Long.valueOf(request.getParameter("giaNhap")));
            BigDecimal giaBan = BigDecimal.valueOf(Long.valueOf(request.getParameter("giaBan")));

            ChiTietSP chiTietSP = new ChiTietSP(id, sanPham, nsx, mauSac, dongSP, namBH, moTa, soLuongTon, giaNhap, giaBan);

            chiTietSanPhamRepository.updateChiTietSP(chiTietSP);

            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }
    }
}

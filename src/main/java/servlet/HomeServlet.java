package servlet;

import entity.Cart;
import entity.CartItem;
import entity.ChiTietSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChiTietSanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = {"/trang-chu/hien-thi"
        , "/trang-chu/add"
        , "/trang-chu/cart"
})
public class HomeServlet extends HttpServlet {

    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            ArrayList<ChiTietSP> chiTietSPs = chiTietSanPhamRepository.getAll();
            request.setAttribute("chiTietSPs", chiTietSPs);
            request.getRequestDispatcher("/view/home.jsp").forward(request, response);
        } else if(uri.contains("cart")){
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
        } else if(uri.contains("add")){
            String id = request.getParameter("id");
            ChiTietSP chiTietSP = chiTietSanPhamRepository.detail(new ChiTietSP(id));

            CartItem cartItem = new CartItem();
            cartItem.setProductId(id);
            cartItem.setProductName(chiTietSP.getSanPham().getTen());
            cartItem.setPrice(chiTietSP.getGiaBan());

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null){
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            cart.addItem(cartItem);

            response.sendRedirect("hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

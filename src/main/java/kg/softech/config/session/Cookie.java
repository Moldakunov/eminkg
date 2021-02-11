package kg.softech.config.session;

import kg.softech.model.cart.Cart;
import kg.softech.repository.CookiesRepository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class Cookie {
    public static void workingWithCookie(CookiesRepository cookiesRepository, String givenCookie, HttpServletResponse response, Model model) {
        javax.servlet.http.Cookie cookie;
        if (givenCookie.isEmpty()) {
            cookie = new javax.servlet.http.Cookie("JSESSIONID", SessionIdGenerator.getInstance().getSessionId());
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
            model.addAttribute("cartCount", 0);
        } else {
            if (cookiesRepository.findBySessionId(givenCookie) != null) {
                Cart cart = cookiesRepository.findBySessionId(givenCookie);

                model.addAttribute("cartCount", Arrays.asList(cart.getProducts().split(",")).size());
            } else {
                model.addAttribute("cartCount", 0);
            }
        }
    }
}

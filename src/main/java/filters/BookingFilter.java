package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "BookingFilter")
public class BookingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String departureDate = req.getParameter("departureDate");
        int flightNumber = Integer.parseInt(req.getParameter("flightNumber"));
        String regex = "^((13|14)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$";
        if (departureDate.matches(regex)) {
            if (flightNumber > 99 && flightNumber < 1000) {
                chain.doFilter(req, resp);
            } else {
                resp.setContentType("text/html;charset=UTF-8");
                req.getRequestDispatcher("/ticketSystem.html").include(req, resp);
                writer.println("Your Flight Number should be equal 3 digits!Try again!");
            }

        } else {
            resp.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/ticketSystem.html").include(req, resp);
            writer.println("The Date Format is Wrong!!");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

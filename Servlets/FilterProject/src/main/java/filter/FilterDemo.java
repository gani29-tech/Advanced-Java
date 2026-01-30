package filter;
import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter("/FilterDemo")
public class FilterDemo implements Filter {
 
	public void init(FilterConfig config) {
		System.out.println("Filter Authentication Demo Started !!");
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		

	}public void destroy() {
	    System.out.println("Filter destroyed");
	}

}
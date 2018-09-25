package top.jbzm.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author zhengyi
 * @date 2018/8/30 3:09 PM
 **/
@Slf4j
public class BeforeLoginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("this is login before filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public static class AfterCsrfFilter extends GenericFilterBean {

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            logger.info("this is csr before filter");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

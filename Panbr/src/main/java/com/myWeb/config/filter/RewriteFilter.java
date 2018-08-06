package main.java.com.myWeb.config.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class RewriteFilter implements Filter {
	public static final String REWRITE_TO = "rewriteUrl";

	public static final String REWRITE_PATTERNS = "urlPatterns";

	private Set<String> urlPatterns = null;

	private String rewriteTo = null;

	@Override
	public void init(FilterConfig cfg) {
		rewriteTo = cfg.getInitParameter(REWRITE_TO);
		String exceptUrlString = cfg.getInitParameter(REWRITE_PATTERNS);
		if (!StringUtils.isEmpty(exceptUrlString)) {
			urlPatterns = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(exceptUrlString.split(";", 0))));
		} else {
			urlPatterns = Collections.emptySet();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stubs
		System.out.println("Filter BEGIN");
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		String context = req.getContextPath();
		if (isMatches(urlPatterns, servletPath)) {
			request.getRequestDispatcher(context+"/"+rewriteTo).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean isMatches(Set<String> patterns, String url) {
		// TODO Auto-generated method stub
		if (null == patterns) {
			return false;
		}
		for (String str : patterns) {
			if (str.endsWith("/")) {
				String name = str.substring(0, str.length() - 2);
				if (url.contains(name)) {
					return true;
				} else {
					Pattern pattern = Pattern.compile(str);
					if (pattern.matcher(url).matches()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

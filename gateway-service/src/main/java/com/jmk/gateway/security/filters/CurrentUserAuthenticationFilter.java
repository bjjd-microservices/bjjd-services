package com.jmk.gateway.security.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CurrentUserAuthenticationFilter extends ZuulFilter {
	  @Override
	    public String filterType() {
	        return "pre";
	    }

	    @Override
	    public int filterOrder() {
	        return 1;
	    }

	    @Override
	    public boolean shouldFilter() {
	        return true;
	    }

	    @Override
	    public Object run() {
	        RequestContext ctx = RequestContext.getCurrentContext();
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        ctx.addZuulRequestHeader("username", auth.getName());
	        return null;
	    }
}


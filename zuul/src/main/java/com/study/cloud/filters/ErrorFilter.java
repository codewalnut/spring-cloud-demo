package com.study.cloud.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发生错误时调用的过滤器
 *
 * @author KelvinZ
 * @date 2018-11-05 23:49
 */
@Component
public class ErrorFilter extends ZuulFilter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("{} invoked", getClass().getSimpleName());
		return null;
	}

}

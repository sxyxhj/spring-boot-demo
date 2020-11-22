package org.sxyxhj.springcloudzuuldemo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-demo
 * @description: 前置过滤器
 * @author: @sxyxhj
 * @create: 2020-11-21 17:22
 **/
@Component
public class TrackingFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER=true;

    @Autowired
    FilterUtils filterUtils;

    // 告诉Zuul是哪种类型的过滤器
    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    //返回一个整数值，指示不同类型的的过滤器执行顺序
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    //返回一个boolean值，指示该过滤器是否需要执行
    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    //此方法是每次服务通过过滤器时执行的代码
    @Override
    public Object run() throws ZuulException {

        System.out.println("filter 11111111111111");
        return null;
    }
}

    

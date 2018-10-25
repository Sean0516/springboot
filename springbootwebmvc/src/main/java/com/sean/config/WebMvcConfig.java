package com.sean.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置静态资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * addResourceHandler 对外暴露的访问路径   addResourceLocations 文件存放的路径
         */
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/test1/**").addPathPatterns("/test2/**");
        super.addInterceptors(registry);
    }

    /**
     * 视图控制器
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("viewUser").setViewName("user/viewUser");
        super.addViewControllers(registry);
    }

    /**
     * 路径匹配设置
     * 在springmvc 中，如果访问路径带有“.” ，则后面的值会被忽略。如果不想忽略的话，可以重写 configurepathmath来来实现
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
        super.configurePathMatch(configurer);
    }

    public class CustomInterceptor implements HandlerInterceptor{
        /**
         * 在业务请求之前调用
         * 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
         * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕
         *    再执行被拦截的Controller
         *    然后进入拦截器链,
         *    从最后一个拦截器往回执行所有的postHandle()
         *    接着再从最后一个拦截器往回执行所有的afterCompletion()
         * @param httpServletRequest
         * @param httpServletResponse
         * @param o
         * @return
         * @throws Exception
         */
        @Override
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            System.out.println("进入业务请求之前拦截器");
            return true;
        }

        /**
         * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
         * @param httpServletRequest
         * @param httpServletResponse
         * @param o
         * @param modelAndView
         * @throws Exception
         */
        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
            System.out.println("业务请求完成后，执行的信息");
        }

        /**
         * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
         * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
         * @param httpServletRequest
         * @param httpServletResponse
         * @param o
         * @param e
         * @throws Exception
         */
        @Override
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
            System.out.println("完全处理完请求后被调用");
        }
    }

}

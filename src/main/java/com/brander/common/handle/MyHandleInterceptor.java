package com.brander.common.handle;


import com.brander.common.domain.FoFunction;
import com.brander.common.service.FoFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建一个拦截器，拦截Controller
 * 需要实现 HandlerInterceptor 接口
 */
public class MyHandleInterceptor implements HandlerInterceptor {

    /*
    * 在Controller调用之前运行
    * return false 将不会执行任何控制
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //System.out.println("==preHandle:在Controller调用之前运行==" + o.getClass());
        String uri = request.getRequestURI();
        if(uri.indexOf("/admin/") != -1){//如果为后台页面
            if(uri.indexOf("/admin/login") != -1 || uri.indexOf("/admin/kaptcha") != -1){
                //如果是后台登录页面或是后台验证码页面，不作任何处理
            }else{
                //判断后台是否有用户登录，没有登录跳转到登录页面
                HttpSession session = request.getSession();
                if(session.getAttribute("adminId") == null){
                    response.sendRedirect("/admin/login");
                }
            }
        }
        return true;
    }

    /*
    * 在Controller调用之后 且 页面渲染之前运行
    * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("==postHandle:在Controller调用之后 且 页面渲染之前运行==" + o.getClass()+"-----"+httpServletResponse.getStatus());

        if(httpServletResponse.getStatus()==500){
            modelAndView.setViewName("pages/500");
        }else if(httpServletResponse.getStatus()==400){
            modelAndView.setViewName("pages/400");
        }else if(httpServletResponse.getStatus()==401){
            modelAndView.setViewName("pages/401");
        }else if(httpServletResponse.getStatus()==404){
            modelAndView.setViewName("pages/404");
        }

    }

    /*
    * 在Controller调用之后 且 页面渲染之后运行，一般进行清理资源操作
    * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("==afterCompletion:在Controller调用之后 且 页面渲染之后运行==" + o.getClass());
    }
}

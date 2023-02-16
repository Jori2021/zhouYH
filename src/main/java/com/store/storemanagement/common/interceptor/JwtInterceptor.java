package com.store.storemanagement.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.store.storemanagement.Exception.ServiceException;
import com.store.storemanagement.common.Constants;
import com.store.storemanagement.entity.User;
import com.store.storemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse  response,Object handler) {
        String token =request.getHeader("token");//获取token
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //认证token
        if(StrUtil.isBlank(token)){
            throw new ServiceException(Constants.CODE_401,"无token，请重新登录");
        }
        //
        String userId;
        try{
            userId= JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(Constants.CODE_401,"token验证失败");
        }

        //根据token的userid查询数据库
        User user=userService.getById(userId);
        if(user == null){
            throw new ServiceException(Constants.CODE_401,"用户名不存在，请重新登录");
        }

        //用户密码加签验证 token
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try{
            jwtVerifier.verify(token);
        }catch(JWTVerificationException e){
            throw new ServiceException(Constants.CODE_401,"token验证失败，请重新登录");
        }
        return true;
    }
}

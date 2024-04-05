package com.gdu.myapp.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gdu.myapp.mapper.UserMapper;

public class MyHttpSessionListener implements HttpSessionListener {
  
  @Override
  public void sessionCreated(HttpSessionEvent se) {

    // session
    HttpSession session = se.getSession();
    
    // sessionId
    String sessionId = session.getId();
    
    System.out.println(sessionId + " 세션 정보가 생성되었습니다.");
    
  }
  // 세션 만료 시 자동으로 동작
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    
    // session
    HttpSession session = se.getSession();
    
    // ApplicationContext
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
    
    // sessionId
    String sessionId = session.getId();
    
    // getBean() 을 활용한 UserMapper Bean 가져오기 (@Autowired 동작하지 않기 때문) 
    UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);

    // update
    userMapper.updateAccessHistory(sessionId);
    
    // 확인 메시지
    System.out.println(sessionId + " 세션 정보가 소멸되었습니다.");
    
  }
  
}
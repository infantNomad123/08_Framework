package edu.kh.project.websocket.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;

/** SessionHandshakeInterceptor 클래스
 *  WebSocketHandler 가  동작하기 전 /후에 
 *  연결된 클라이언트 세션을 가로채는 동작을 작성할 클래스
 */

@Component // bean 등록
public class SessionHandshakeInterceptor implements HandshakeInterceptor {
	
	//Handler 동작 전애 수행되는 메서드
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		//ServerHttpRequest : HttpServletRequest 의 부모 인터페이스
		//ServerHttpResponse : HttpServletResponse의 부모 인터페이스
		// attributes                :  해당 맵에 세팅된 속성 (데이터) 은 
		//                                  다음에 동작할 Handler 갹체에게 전달됨 
		//                                (HandshakeInterceptor -> Handler 데이터 전달하는 역할)
		
		
		// Checking if request is the subclass of ServletServerHttpRequest
		//request 가 참조하는 객체가 
		// ServletServerHttpRequest로 다운캐스팅이 가능한가?
		if(request instanceof ServletServerHttpRequest) {
			
			// 다운캐스팅
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			
			HttpSession session = servletRequest.getServletRequest().getSession();
			
			
			//Interceptor intercepts client's session during handshake and forward it to handler method
			
			//가로챈 세션을 Handler에 전당할 수 있게 값 세팅
			attributes.put("session", session);
		}
		
		return true; // 가로채기 진행 여부 true // true로 작성해야 세션 가로채서 Handler에게 전달 가능
	}
    
	// Handler 동작 후에 수행되는 메서드
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

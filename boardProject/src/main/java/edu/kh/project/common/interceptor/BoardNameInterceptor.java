package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardNameInterceptor implements HandlerInterceptor {
	
	
	//후처리 (Controller -> dispatcher Servlet 사이)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// application scope 에서 boardTypeList 얻어오기
		ServletContext application = request.getServletContext();
		
		//boardTypeList
		// [{boardCode:1, boardName=공지 게시판, {boardCode : 2, boardName = 자유},.....]
		
		List<Map<String,Object>> boardTypeList  = (List<Map<String,Object>>)application.getAttribute("boardTypeList");
		
		log.debug(boardTypeList.toString());
		
		//Uniform Resource Identifier : 통합 자원 식별자
		// - 자원 이름(주소)만 봐도 무엇인지 구별할 수 있는 문자열
		
		// uri : /board/1
		
		// url : localhost/board/1  -> locator
	 
		String uri = request.getRequestURI();
//		log.debug("uri : " + uri);
			
		try{//["", "board", "1"]
		int boardCode = Integer.parseInt(uri.split("/")[2]);
		
		//boardTypeList 에서 boardCode를 하나씩 꺼내어 비교
		for(Map<String,Object> boardType : boardTypeList) {
			//String.valueOf(값) : String 으로 변환
			int temp = Integer.parseInt(String.valueOf(boardType.get("boardCode")));
			
			
			//비교 결과가 같다면
			// request scope 에 boardName 을 추가
			if(temp == boardCode) {
				request.setAttribute("boardName", boardType.get("boardName"));
				break;
			}
		}
		}
		catch(Exception e){
			
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		
	}
	
	
	

}

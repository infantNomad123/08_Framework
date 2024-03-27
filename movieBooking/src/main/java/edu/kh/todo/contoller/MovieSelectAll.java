package edu.kh.todo.contoller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.todo.model.dto.Movie;
import edu.kh.todo.model.service.MovieService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MovieSelectAll {
	
	@Autowired  // 등록된 Bean 중 같은 타입 or 상속 관계 DI(의존성 주입)
	private MovieService service ;
	
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		
	
		
		//Service  메서드 호출 후 결과 반환 받기
		Map<String, Object> map = service.selectAll();
		
		//map 에 담긴 내용 추출
		List<Movie> movieList = (List<Movie>)map.get("movieList");
		
		
		
		//Model 에
		model.addAttribute("movieList",movieList);
		
		
		
		//classpath: /templates/common/main.html 로 forward
		return "common/main";
	}
	
}

package edu.kh.todo.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.todo.model.dto.Todo;

public interface TodoService {

	/**할 일 목록 + 완료된 할 일 개수 조회
	 * @return map
	 */
	Map<String, Object> selectAll();

	/**할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return
	 */
	int addTodo(String todoTitle, String todoContent);

	/**할 일 상세 조회
	 * @param todoNo
	 * @return todo
	 */
	Todo todoDetail(int todoNo);

	int todoDelete(int todoNo);





	int todoUpdate(Todo todo);

	int changeComplete(Todo todo);

	/**전체 할 일 개수 조회
	 * @return
	 */
	int getTotalCount();

	int getCompleteCount();

	/**할 일 목록 조회
	 * @return todoList
	 */
	List<Todo> selectList();








}

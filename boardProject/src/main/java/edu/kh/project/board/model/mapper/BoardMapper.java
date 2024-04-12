package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/**게시판 종류 조회
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();

	/**게시글 수를 조회
	 * @param boardCode
	 * @return  listCount
	 */
	int getListCount(int boardCode);

	/**특정 
	 * @param boardCode
	 * @param rowBounds
	 * @return
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/**
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Object> map);

}
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

	/**게시글 상세 조회
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Object> map);

	/**좋아요 해제 (DELETE)
	 * @param map
	 * @return result
	 */
	int deleteBoardLike(Map<String, Integer> map);

	/**좋아요 체크(INSERT)
	 * @param map
	 * @return result
	 */
	int insertBoardLike(Map<String, Integer> map);

	/**게시글 좋아요 개수 조회
	 * @param temp
	 * @return count
	 */
	int selectLikeCount(int temp);

	/** 조회수 1 증가
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);

	/**조회수 조회
	 * @param boardNo
	 * @return
	 */
	int selectReadCount(int boardNo);

	/**검색 조건이 맞는 세기슬 수 조회
	 * @param paramMap
	 * @return  count
	 */
	int getSearchCount(Map<String, Object> paramMap);

	/**검색 결과 목록 조회
	 * @param paramMap
	 * @param rowBounds
	 * @return boardList
	 */
	List<Board> selectSearchList(Map<String, Object> paramMap, RowBounds rowBounds);

}

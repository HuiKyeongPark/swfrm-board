package board.service;

import board.dao.BoardDao;
import board.dto.Board;
import board.dto.BoardAccess;
import board.exception.BoardNotFoundException;
import board.exception.WrongIdPasswordException;

//게시물 삭제
public class BoardDelete {
    private BoardDao boardDao;

    public BoardDelete(BoardDao boardDao){  //DI 의존처리
        this.boardDao = boardDao;
    }
    public void deleteByTitle(BoardAccess access){
        Board board = boardDao.selectByTitle(access.getTitle());

        if(board == null)
            throw new BoardNotFoundException();

        if(!board.checkPassword(access.getPassword()))
            throw new WrongIdPasswordException();

        boardDao.delete(board);
    }
}

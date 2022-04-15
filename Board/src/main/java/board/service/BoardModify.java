package board.service;

import board.dao.BoardDao;
import board.dto.Board;
import board.dto.BoardUpdate;
import board.exception.BoardNotFoundException;
import board.exception.WrongIdPasswordException;

import java.time.LocalDateTime;

//게시물 수정
public class BoardModify {
    private BoardDao boardDao;

    public BoardModify(BoardDao boardDao){  //DI 의존처리
        this.boardDao = boardDao;
    }

    public void modify(BoardUpdate update){
        Board board = boardDao.selectByTitle(update.getTitle());

        if(board == null)
            throw new BoardNotFoundException();

        if(!board.checkPassword(update.getPassword()))
            throw new WrongIdPasswordException();

        board.change(update.getContent());
        board.setUpdatedAt(LocalDateTime.now());

        boardDao.update(board);

    }
}

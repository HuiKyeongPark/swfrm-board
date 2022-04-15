package board.service;

import board.dao.BoardDao;
import board.dto.Board;
import board.dto.BoardUpload;
import board.exception.DuplicateBoardException;

import java.time.LocalDateTime;

public class BoardWrite {
    private BoardDao boardDao;

    public BoardWrite(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public long write(BoardUpload upload){
        Board board = boardDao.selectByTitle(upload.getTitle());

        if(board != null)
            throw new DuplicateBoardException("제목 중복");

        Board newBoard = new Board(
                upload.getTitle(), upload.getContent(), upload.getAuthor(), upload.getPassword(),
                LocalDateTime.now(), null
        );

        boardDao.insert(newBoard);
        return newBoard.getId();
    }
}

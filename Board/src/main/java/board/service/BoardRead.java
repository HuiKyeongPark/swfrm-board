package board.service;

import board.dao.BoardDao;
import board.dto.Board;
import board.dto.BoardAccess;
import board.exception.WrongIdPasswordException;

public class BoardRead {
    private BoardDao boardDao;
    private BoardPrinter printer;

    public void readByTitle(BoardAccess access) {
        Board board = boardDao.selectByTitle(access.getTitle());
        if(board == null){
            System.out.println("해당 제목의 데이터가 없습니다.");
            return;
        }

        if(!board.checkPassword(access.getPassword()))
            throw new WrongIdPasswordException();

        printer.print(board);
        System.out.println();
    }

    public void setBoardDao(BoardDao boardDao){
        this.boardDao = boardDao;
    }
    public void setPrinter(BoardPrinter printer){
        this.printer = printer;
    }
}

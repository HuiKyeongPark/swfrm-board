package board.service;

import board.dao.BoardDao;
import board.dto.Board;

import java.util.Collection;

//게시물 목록 조회
public class BoardListPrinter {
    private BoardDao boardDao;
    private BoardPrinter printer;

    public BoardListPrinter(BoardDao boardDao, BoardPrinter printer) {  //DI 의존처리
        this.boardDao = boardDao;
        this.printer = printer;
    }

    public void printAll(){
        Collection<Board> boards = boardDao.selectAll();
        boards.forEach(b-> printer.print(b));
    }
}

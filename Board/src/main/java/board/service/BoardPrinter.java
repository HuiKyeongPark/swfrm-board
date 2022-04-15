package board.service;

import board.dto.Board;

public class BoardPrinter {
    public void print(Board board) {
        System.out.printf(
                "게시물 정보: 아이디 = %d, 제목 = %s, 내용 = %s, 작성자 = %s, 작성일 = %tF %tT, 수정일 = %tF %tT\n",
                board.getId(), board.getTitle(), board.getContent(), board.getAuthor(),
                board.getCreatedAt(), board.getCreatedAt(), board.getUpdatedAt(), board.getUpdatedAt()
        );
    }
}

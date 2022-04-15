package board.exception;

//키값인 title이 기존에 존재하는 경우 예외처리
public class DuplicateBoardException  extends  RuntimeException{
    public DuplicateBoardException(String message){
        super(message);
    }
}

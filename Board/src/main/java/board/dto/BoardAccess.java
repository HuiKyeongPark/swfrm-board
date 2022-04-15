package board.dto;

//게시물을 읽고 삭제할 때 필요한 정보들 접근하는 클래스
public class BoardAccess {
    private String title;
    private String password;

    public BoardAccess(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

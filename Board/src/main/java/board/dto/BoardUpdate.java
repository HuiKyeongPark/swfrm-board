package board.dto;

//게시물 수정할 때 필요한 정보들 접근하는 클래스
public class BoardUpdate {
    private String title;
    private String content;
    private String password;

    public BoardUpdate(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package board.dto;

//게시물 작성할 때 필요한 정보들 접근하는 클래스
public class BoardUpload {
    private String title;
    private String content;
    private String author;
    private String password;

    public BoardUpload() {

    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

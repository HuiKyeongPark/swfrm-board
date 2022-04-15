package board.dto;

import java.time.LocalDateTime;


public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Board(String title, String content, String author, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Board(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void change(String newContent) {
        this.content = newContent;
    }   //게시물의 내용 수정하고 저장하는 메서드

    public boolean checkPassword(String inputPw) {
        return password.equals(inputPw);
    }   //board에 저장된 비밀번호와 콘솔로 입력받는 비밀번호가 일치하는지
}

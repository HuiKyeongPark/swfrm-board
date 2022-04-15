package board.dao;

import board.dto.Board;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BoardDao {
    private static long nextId = 0 ;
    public Map<String, Board> storage = new HashMap<>();

    public Collection<Board> selectAll() {
            return storage.values();
    }
    public Board selectByTitle(String title) {
            return storage.get(title);
    }

    public void insert(Board board){
            //checkTitle(board.getTitle());
            board.setId(++nextId);
            storage.put(board.getTitle(), board);
    }

    public void update(Board board){
            storage.replace(board.getTitle(), board);
            }

    public void delete(Board board){
            storage.remove(board.getTitle());
    }
}
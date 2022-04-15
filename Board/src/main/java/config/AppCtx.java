package config;

import board.dto.Board;
import board.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import board.dao.BoardDao;

@Configuration
public class AppCtx {
    @Bean
    public BoardDao boardDao() {
        return new BoardDao();
    }

    @Bean
    public BoardPrinter boardPrinter(){
        return new BoardPrinter();
    }

    @Bean
    public BoardListPrinter listPrinter(){
        return new BoardListPrinter(boardDao(), boardPrinter());
    }

    @Bean
    public BoardRead boardRead(){
        BoardRead boardRead = new BoardRead();
        boardRead.setBoardDao(boardDao());
        boardRead.setPrinter(boardPrinter());

        return boardRead;
    }

    @Bean
    public BoardWrite boardWrite() {
        return new BoardWrite(boardDao());
    }

    @Bean
    public BoardModify boardModify(){
        return new BoardModify(boardDao());
    }

    @Bean
    public BoardDelete boardDelete(){
        return new BoardDelete(boardDao());
    }
}

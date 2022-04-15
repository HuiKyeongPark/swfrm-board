package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import board.dto.Board;
import board.dto.BoardAccess;
import board.dto.BoardUpdate;
import board.dto.BoardUpload;
import board.exception.BoardNotFoundException;
import board.exception.DuplicateBoardException;
import board.exception.WrongIdPasswordException;
import board.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;

public class Main {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("명령어를 입력하세요:");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if (command.startsWith("write ")) {
                processWriteCommand(command.split(" "));
                continue;

            } else if (command.startsWith("list")) {
                processListCommand();
                continue;
            } else if (command.startsWith("read ")) {
                processReadCommand(command.split((" ")));
                continue;
            } else if (command.startsWith("modify ")) {
                processModifyCommand(command.split(" "));
                continue;
            } else if (command.startsWith("delete ")) {
                processDeleteCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processWriteCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }
        BoardWrite boardWrite =
                ctx.getBean("boardWrite", BoardWrite.class);
        BoardUpload upload = new BoardUpload();
        upload.setTitle(arg[1]);
        upload.setContent(arg[2]);
        upload.setAuthor(arg[3]);
        upload.setPassword(arg[4]);

        try {
            boardWrite.write(upload);
            System.out.println("작성 완료\n");
        } catch (DuplicateBoardException e) {
            System.out.println("이미 존재하는 제목입니다.\n");
        }
    }


    private static void processListCommand() {
        BoardListPrinter listPrinter = ctx.getBean("listPrinter", BoardListPrinter.class);
        listPrinter.printAll();
        System.out.println();
    }

    private static void processReadCommand(String[] arg) {
        if (arg.length != 3) {
            printHelp();
            return;
        }
        BoardRead boardRead = ctx.getBean("boardRead", BoardRead.class);

        BoardAccess access = new BoardAccess();
        access.setTitle(arg[1]);
        access.setPassword(arg[2]);

        try {
            boardRead.readByTitle(access);
        } catch (BoardNotFoundException e) {
            System.out.println("해당 제목의 게시물이 없습니다.\n");
        }catch (WrongIdPasswordException e) {
            System.out.println("암호가 일치하지 않습니다.\n");
        }
    }
    private static void processModifyCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }
        BoardModify boardModify =
                ctx.getBean("boardModify", BoardModify.class);
        BoardUpdate update = new BoardUpdate();;
        Board board = new Board();
        update.setTitle(arg[1]);
        update.setContent(arg[2]);
        update.setPassword(arg[3]);

        try {
            boardModify.modify(update);
            System.out.println("수정됐습니다.\n");
        } catch (BoardNotFoundException e) {
            System.out.println("해당 제목의 게시물이 없습니다.\n");
        }catch (WrongIdPasswordException e) {
            System.out.println("암호가 일치하지 않습니다.\n");
        }
    }
    private static void processDeleteCommand(String[] arg) {
        if (arg.length != 3) {
            printHelp();
            return;
        }
        BoardDelete boardDelete = ctx.getBean("boardDelete", BoardDelete.class);
        BoardAccess access = new BoardAccess();

        access.setTitle(arg[1]);
        access.setPassword(arg[2]);

        try {
            boardDelete.deleteByTitle(access);
            System.out.printf("<%s> 게시물이 삭제됐습니다.\n", access.getTitle());
        } catch (BoardNotFoundException e) {
            System.out.println("해당 제목의 게시물이 없습니다.\n");
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 일치하지 않습니다.\n");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("명령어 사용법:");
        System.out.println("write 제목 내용 작성자 비밀번호");
        System.out.println("list");
        System.out.println("read 제목 비밀번호");
        System.out.println("modify 제목 수정내용 비밀번호");
        System.out.println("delete 제목 비밀번호");
        System.out.println();
    }
}

package jptvr19library;

import tools.ReaderSaver;
import tools.ReaderManager;
import entity.Reader;
import entity.Book;
import entity.History;
import entity.User;
import java.util.Scanner;
import tools.SecureManager;
import tools.BookSaver;
import tools.HistorySaver;
import tools.UserSaver;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];
    private Book[] books = new Book[10];
    private History[] histories = new History[10];
    private User[] users = new User[100];
    private SecureManager secureManager = new SecureManager();
    private User loginedUser;


    public App() {
        ReaderSaver rsm = new ReaderSaver();
        Reader[] loadedReaders = rsm.loadFile();
        if(loadedReaders != null){
            readers = loadedReaders;
        }
        BookSaver bsm = new BookSaver();
        Book[] loadedBooks = bsm.loadFile();
        if(loadedBooks != null){
            books = loadedBooks;
        }
        HistorySaver historiesStorageManager = new HistorySaver();
        History[] loaderHistories = historiesStorageManager.loadFile();
        if(loaderHistories != null){
            histories = loaderHistories;
        }
        UserSaver userStoreManager = new UserSaver();
        User[] loadedUsers = userStoreManager.loadFile();
        if(loadedUsers != null){
            users = loadedUsers;
        }
    }

    public void run() {
        System.out.println("--- Библиотека ---");

        this.loginedUser = SecureManager.checkTask(users, readers);
        if(SecureManager.Role.READER.toString().equals(loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI(books, readers, histories);
        }else if(SecureManager.Role.MANAGER.toString().equals(loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI(books, readers, histories);

        }

    }

}
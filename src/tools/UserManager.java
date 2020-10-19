package tools;

import entity.Reader;
import entity.User;
import java.util.Scanner;
import tools.ReaderManager;

public class UserManager {
    private Scanner scanner = new Scanner(System.in);

    public User regUser() {
        ReaderManager readerManager = new ReaderManager();
        Reader reader = readerManager.createReader();
        return createUser(reader);
    }

    public User createUser(Reader reader) {
        User user = new User();
        System.out.println("--- Регистрация пользователя ---");
        System.out.print("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        user.setRole(this.getUserRole());
        user.setReader(reader);
        return user;
    }
    public User getAuthUser(User[] users) {
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
            System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
            for(
        int i = 0;
        i<users.length;i++)

        {
            User user = users[i];
            if (login.equals(user.getLogin())) {
                for (int j = 0; j < 3; j++) {
                    if (password.equals(user.getPassword())) {
                        return user;
                    } else {
                        System.out.println("Неправильный пароль. Попробуйте еще раз");
                        System.out.print("Введите пароль:");
                        password = scanner.nextLine();
                    }
                }
                System.out.println("Вы не авторизовались. До свидания!");
                System.exit(0);
            }
        }

            return null;
    }
    public void addUserToArray(User user, User[] users){
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                users[i]=user;
                break;
            }
        }
    }

    private String getUserRole() {
        int numberRole = 0;
        do{
            System.out.print("Роль: ");
            for (int i = 0; i < SecureManager.Role.values().length; i++) {
                System.out.println(i+1+". "+SecureManager.Role.values()[i].toString());
            }
            System.out.print("Выберите номер роли: ");
            String numberRoleStr = scanner.nextLine();
            try {
                numberRole = Integer.parseInt(numberRoleStr);
                return SecureManager.Role.values()[numberRole - 1].toString();
            } catch (Exception e) {
                System.out.println("Нет такой роли. Выберите номер из списка: ");
            }
        }while(true);
    }
}
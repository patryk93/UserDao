package pl.coderslab;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Scanner;

public class Main {

    static final String[] OPTIONS = {"create", "read", "update", "delete", "list", "exit"};
    public static void main(String[] args){

        User user = new User();
        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);
        showOptions(OPTIONS);
        String input = scanner.nextLine();
        while (!"exit".equals(input)) {
            switch (input) {
                case "create" -> {
                    System.out.println("Please add a UserName");
                    user.setUserName(scanner.nextLine());
                    System.out.println("Please add an email");
                    user.setEmail(scanner.nextLine());
                    System.out.println("Please add a password");
                    user.setPassword(scanner.nextLine());
                    userDao.create(user);
                    System.out.println("User has been added correctly");
                }
                case "read" -> {
                    System.out.println("Please add an ID");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        user = userDao.read(id);
                        System.out.println("User ID = " + user.getId());
                        System.out.println("UserName = " + user.getUserName());
                        System.out.println("Email = " + user.getEmail());


                    } catch (NumberFormatException e) {
                        System.out.println("Please add correct ID");
                    }
                }
                case "update" -> {
                    System.out.println("Please add an ID");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        user = userDao.read(id);
                        userDao.update(user);
                    } catch (NumberFormatException e) {
                        System.out.println("Please type correct ID");
                    }

                }
                case "delete" -> {
                    System.out.println("Please add an ID");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        userDao.delete(id);
                        System.out.println("User has been deleted successfully");

                    } catch (NumberFormatException e) {
                        System.out.println("Please type correct ID");
                    }

                }
                case "list" -> userDao.findAll();

                default -> {
                    System.out.println("Please select a correct option");
                }

            }
            System.out.println();
            showOptions(OPTIONS);
            input = scanner.nextLine();
        }
        System.out.println("Bye, bye.");
    }

    public static void showOptions(String[] options) {
        System.out.println("Please select an option: " );
        for (String option : options) {
            System.out.println(option);
        }
    }

}
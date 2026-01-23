package Patterns.RepositoryAndIteratorPattern;

import java.util.List;

import Patterns.RepositoryAndIteratorPattern.repositories.UserRepositories;
import Patterns.RepositoryAndIteratorPattern.services.UserService;

public class BasicDemo {
    public static void main(String[] args) {

        InMemDB inMemDB = new InMemDB();
        inMemDB.seededUsers();

        UserRepositories userRepositories = new UserRepositories(inMemDB);
        UserService userService = new UserService(userRepositories);

        List<String> users = userService.getUsers(10, 1);
        System.out.println(users);

        users = userService.getUsers(10, 2);
        System.out.println(users);

        users = userService.getUsers(10, 3);
        System.out.println(users);

        users = userService.getUsers(10, 4);
        System.out.println(users);
    }
}

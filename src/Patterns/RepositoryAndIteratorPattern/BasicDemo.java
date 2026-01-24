package Patterns.RepositoryAndIteratorPattern;

import java.util.List;

import Patterns.RepositoryAndIteratorPattern.Iterator.UserIterator;
import Patterns.RepositoryAndIteratorPattern.repositories.UserRepositories;
import Patterns.RepositoryAndIteratorPattern.services.UserService;

public class BasicDemo {
    public static void main(String[] args) {

        //normal one

        InMemDB inMemDB = new InMemDB();
        // seededUsers() is already called in InMemDB constructor

        UserRepositories userRepositories = new UserRepositories(inMemDB);
        UserService userService = new UserService(userRepositories);

        List<String> users = userService.getUsers(3, 1);
        System.out.println(users);

        users = userService.getUsers(3, 2);
        System.out.println(users);

        // users = userService.getUsers(2, 3);
        // System.out.println(users);

        // users = userService.getUsers(10, 4);
        // System.out.println(users);

        // To know whether more users exist after each pagination call
        // we can use iterator pattern

        // using iterator pattern

            System.out.println("--------------------------------");

                System.out.println("Using iterator pattern");

        UserIterator userIterator = new UserIterator(userRepositories, 3, 1);
        while(userIterator.hasNext()){
            List<String> userList = userIterator.next();
            System.out.println(userList);
        }
    }
}

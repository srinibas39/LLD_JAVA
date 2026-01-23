package Patterns.RepositoryAndIteratorPattern.repositories;

import java.util.List;

import Patterns.RepositoryAndIteratorPattern.InMemDB;

public class UserRepositories implements IUserRepositories {

    private final InMemDB inMemDB;

    public UserRepositories(InMemDB inMemDB) {
        this.inMemDB = inMemDB;
    }
    

    @Override
    public List<String> findUsers(int limit, int offset) {
        //For example limit = 10 and offset = 2 then we will return users 11 to 20
        List<String> users = inMemDB.getUsers();
        int start =( offset - 1) * limit;
        int end = Math.min(start + limit, users.size());

        if(start >= users.size()) {
            return List.of();
        }

        return users.subList(start , end);

    }
}

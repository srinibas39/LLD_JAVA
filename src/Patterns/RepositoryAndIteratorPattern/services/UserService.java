package Patterns.RepositoryAndIteratorPattern.services;

import java.util.List;

import Patterns.RepositoryAndIteratorPattern.repositories.IUserRepositories;

public class UserService {

    private final IUserRepositories userRepositories;

    public UserService(IUserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    // controller --> limit , offset --> service --> repository --> DB
    public List<String> getUsers(int limit, int offset) {
        return userRepositories.findUsers(limit, offset);
    }


}

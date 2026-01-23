package Patterns.RepositoryAndIteratorPattern.repositories;

import java.util.List;

public interface IUserRepositories {
    List<String> findUsers(int limit  , int offset);
}

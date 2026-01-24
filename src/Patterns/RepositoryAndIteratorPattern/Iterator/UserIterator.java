package Patterns.RepositoryAndIteratorPattern.Iterator;

import java.util.List;

import Patterns.RepositoryAndIteratorPattern.repositories.UserRepositories;

public class UserIterator implements Iterator<List<String>> {


    private final UserRepositories userRepositories;
    private int limit = 0;
    private int offset = 1;
    private List<String> current;

    public UserIterator(UserRepositories userRepositories, int limit, int offset) {
        this.userRepositories = userRepositories;
        this.limit = limit;
        this.offset = offset;
        // intially load the current list of pages
        this.current = userRepositories.findUsers(limit, offset); 
    }


    @Override
    public boolean hasNext() {
        return current != null && !current.isEmpty();
    }

    @Override
    public List<String> next() {
        
        if(!hasNext()) {
            return List.of();
        }

       List<String> nextPages = current;
        offset = offset + 1;
  
        current = userRepositories.findUsers(limit, offset);
        
        // If the next page is empty, we've reached the end
        if(current.isEmpty()) {
            current = null; // Mark as no more pages
        }
        
        return nextPages;
    }
}

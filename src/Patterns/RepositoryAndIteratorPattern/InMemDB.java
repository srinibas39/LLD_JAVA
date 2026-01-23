package Patterns.RepositoryAndIteratorPattern;

import java.util.ArrayList;
import java.util.List;

//Think of this SQL DB

public class InMemDB {

    
    private List<String> users;

    public InMemDB() {
        this.users = new ArrayList<>();
        seededUsers();
    }


    public List<String> getUsers() {
        return users;
    }

    
    public void seededUsers() {
       for(int i = 1; i <= 1000; i++) {
        this.users.add("User" + i);
       }
    }



    
}

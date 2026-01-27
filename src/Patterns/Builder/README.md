# Builder Pattern

## Create a user class with multiple attributes , we also need to add much of validation which include a combination
## Example : firstname and lastname should be same

```
class User {

    String firstname;
    String lastname;
    int age;
    String email;
    String password;
  
}

```

Problems is it is public , anybody change our properites,
So we need to make it private and use getters and setters  
In setter , we also put validations but the problem is the object is already created with default values So till the setters are called , the object is not valid

Solutions is custom constructor apart from getter and setter with all the properties and validation 

```
class User {

    String firstname;
    String lastname;
    int age;
    String email;
    String password;

    public User(String firstname, String lastname, int age, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;

        if(firstname == null || firstname.isEmpty()){
            throw new IllegalArgumentException("First name is required");
        }
        if(lastname == null || lastname.isEmpty()){
            throw new IllegalArgumentException("Last name is required");
        }
        if(age < 0){
            throw new IllegalArgumentException("Age must be greater than 0");
        }
    }
    if(email == null || email.isEmpty()){
        throw new IllegalArgumentException("Email is required");
    }
    if(password == null || password.isEmpty()){
        throw new IllegalArgumentException("Password is required");
    }
    if(password.length() < 8){
        throw new IllegalArgumentException("Password must be at least 8 characters long");
    }
    if(!email.contains("@")){
        throw new IllegalArgumentException("Email must contain @");
    }
    if(!email.contains(".")){
        throw new IllegalArgumentException("Email must contain .");
    }
}
```

Problem is there are too many parameters , order of parameters is important , if we want to add a new property , we need to add it to the constructor and the validation will be complex . So , code is bloated and difficult to maintain.
And one more problem is every field is required , so we need to pass all the parameters even if we don't want to set some of the fields.

we can make also make multiple constructors with different parameters , but this is not a good solution because we are duplicating the code and it is not DRY.

constructor(a  , b , c) , instead of passing values for a , b , c , we can pass a map of properties and values , if we want to add a new property , we can add it to the map.


```
class User {

    String firstname;
    String lastname;
    int age;
    String email;
    String password;

}

public User(Map<String, Object> properties) {
    this.firstname = (String) properties.get("firstname");
    this.lastname = (String) properties.get("lastname");
    this.age = (int) properties.get("age");
    this.email = (String) properties.get("email");
    this.password = (String) properties.get("password");
}
```


But a better solution is to have a temporary builder class to build the user object with all the properties and validation and then build the user object , and instead of mapper we can use builder to build the user object.

```
class Builder {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
}

public Builder firstname(String firstname) {
    // set validations for firstname
    if(firstname == null || firstname.isEmpty()){
        throw new IllegalArgumentException("First name is required");
    }
    this.firstname = firstname;
    return this;
}

public Builder lastname(String lastname) {
    // set validations for lastname
    if(lastname == null || lastname.isEmpty()){
        throw new IllegalArgumentException("Last name is required");
    }
    this.lastname = lastname;
    return this;
}

public Builder age(int age) {
    // set validations for age
    if(age < 0){
        throw new IllegalArgumentException("Age must be greater than 0");
    }
    this.age = age;
    return this;
}

public Builder email(String email) {
    // set validations for email
    if(email == null || email.isEmpty()){
        throw new IllegalArgumentException("Email is required");
    }
    this.email = email;
    return this;
}

public Builder password(String password) {
    // set validations for password
    if(password == null || password.isEmpty()){
        throw new IllegalArgumentException("Password is required");
    }
    if(password.length() < 8){
        throw new IllegalArgumentException("Password must be at least 8 characters long");
    }
    if(!email.contains("@")){
        throw new IllegalArgumentException("Email must contain @");
    }
    if(!email.contains(".")){
        throw new IllegalArgumentException("Email must contain .");
    }
    this.password = password;
    return this;
}

public User build() {
    return new User(this);
}
```

```
User user = new Builder()
    .firstname("John")
    .lastname("Doe")
    .age(20)
    .email("john.doe@example.com")
    .password("password")
    .build();
```

Now we can function chaining to set the properties and build the user object.

//We can make builder class as a static inner class of the User class
```
class User {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;

    public static class Builder {
        private String firstname;
        private String lastname;
        private int age;
        private String email;
        private String password;

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder password(String password) {
            this.password = password;

            if(password == null || password.isEmpty()){
                throw new IllegalArgumentException("Password is required");
            }
            if(password.length() < 8){
                throw new IllegalArgumentException("Password must be at least 8 characters long");
            }
            if(!email.contains("@")){
                throw new IllegalArgumentException("Email must contain @");
            }
            if(!email.contains(".")){
                throw new IllegalArgumentException("Email must contain .");
            }   
            return this;
        }

        public User build() {
            return new User(this.firstname, this.lastname, this.age, this.email, this.password);
        }
    }
}   
```

```
User user = User.Builder.firstname("John")
    .lastname("Doe")
    .age(20)
    .email("john.doe@example.com")
    .password("password")
    .build();
```

Now we can function chaining to set the properties and build the user object.

```
User user = User.Builder.firstname("John")


Builder pattern is a creational design pattern that is used to create complex objects by chaining the methods together.
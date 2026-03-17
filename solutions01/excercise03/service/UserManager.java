package solutions01.excercise03.service;

import java.util.ArrayList;
import java.util.List;

import solutions01.excercise03.models.User;

public class UserManager {

    private List<User> users = new ArrayList<User>();

    public UserManager() {
    }

    private int autoIncrementId() {

        if (users.size() == 0) {
            return 1;
        } else {
            int lastId = users.get(users.size() - 1).getId();
            return lastId + 1;
        }

    }

    public boolean userExistbyId(int id) {

        User userExists = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

        return (userExists == null) ? false : true;
    }

    public boolean AddUser(String firstname, String lastname, int age) {

        User newUser = new User();
        newUser.setId(autoIncrementId());
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setAge(age);

        users.add(newUser);
        return true;
    }

}

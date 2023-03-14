package org.example;

import java.util.Random;

public class UserFactory {
    public static User createUser() {
        Random rand = new Random();
        String name = "Anonymous_" + rand.nextInt(100);
        int age = rand.nextInt(100);
        return new User(name, age);
    }

    public static User[] createUsersArray(int userNums) {
        User[] users = new User[userNums];
        for(int i = 0; i < userNums; i++) {
            users[i] = createUser();
        }
        return users;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GroupFactory {

    public static Group createGroup() {
        Random rand = new Random();
        return new Group("Group #" + rand.nextInt(100));
    }
    public static List<Group> createGroupsWithUsers(int groupNums, int userNums) {
        List<Group> groups = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < groupNums; i++) {
            groups.add(createGroup());
        }

        User[] users = UserFactory.createUsersArray(userNums);
        for(User user: users) {
            int groupNumber = rand.nextInt(groupNums);
            Group group = groups.get(groupNumber);
            user.setGroup(group);
            group.getUsers().add(user);
        }

        return groups;
    }

    public static Group getGroupWithUsers() {
        Random rand = new Random();
        int numUsers = 1 + rand.nextInt(3);
        User[] users = UserFactory.createUsersArray(numUsers);
        Group group = GroupFactory.createGroup();
        Arrays.stream(users).forEach(user -> {
            group.getUsers().add(user);
            user.setGroup(group);
        });
        return group;
    }

    public static List<Group> get5x5() {
        List<Group> groups = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Group group = createGroup();
            User[] users = UserFactory.createUsersArray(5);
            group.setUsers(Arrays.asList(users));
            group.getUsers().stream().forEach(u -> u.setGroup(group));
            groups.add(group);
        }
        return groups;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Group {
    private static int total;

    private int id;
    private String name;
    private Collection<User> users;

    public Group() {
        this.users = new ArrayList<>();
    }
    public Group(String name) {
        this.id = ++total;
        this.name = name;
        this.users = new ArrayList<User>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users.stream()
                .map(u -> "#" + u.getId() + ":" + u.getName())
                .collect(Collectors.joining(", ", "(", ")"))
                + '}';
    }
}

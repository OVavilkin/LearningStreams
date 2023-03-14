package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {

    public static Optional<Group> getFindFirst(Stream<Group> groups) {
        return groups.findFirst();
    }

    public static Optional<Group> getFindAny(Stream<Group> groups) {
        return groups.findAny();
    }

    public static long getCount(Stream<Group> groups) {
        return groups.count();
    }

    public static boolean getAnyMatch(Stream<Group> groups) {
        return groups.anyMatch(group -> group.getId() % 2 == 0);
    }

    public static boolean getNoneMatch(Stream<Group> groups) {
        return groups.noneMatch(group -> group.getUsers().size() > 10);
    }

    public static boolean getAllMatch(Stream<Group> groups) {
        return groups.allMatch(group -> group.getUsers().size() > 1);
    }

    public static Optional<Group> getMin(Stream<Group> groups) {
        return groups.min((g1, g2) -> g1.getId() - g2.getId());
    }

    public static Optional<Group> getMax(Stream<Group> groups) {
        return groups.max((g1, g2) -> g1.getId() - g2.getId());
    }

    public static void getForEachOrdered(Stream<Group> groups) {
        groups.forEachOrdered(group -> {
            System.out.println("Group id #" + group.getId());
            System.out.println("Has " + group.getUsers().size() + " users");
        });
    }

    public static Group[] getToArray(Stream<Group> groups) {
        return groups.toArray(Group[]::new);
    }

    public static List<User> getReduceHardWay(Stream<Group> groups) {
        return groups.reduce(
                new ArrayList<User>(),
                (list, group) -> {
                    list.addAll(group.getUsers());
                    return list;
                },
                (first, second) -> {
                    first.addAll(second);
                    return first;
                }
        );
    }

    public static Group getReduceEasy(Stream<Group> groups) {
        return groups.reduce((g1, g2) ->
                g1.getUsers().size() > g2.getUsers().size() ? g1 : g2).get();
    }

}

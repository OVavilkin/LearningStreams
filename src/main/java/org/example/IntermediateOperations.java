package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static Stream<Group> getFiltered(Stream<Group> groups) {
        return groups.filter(group -> group.getUsers().size() > 0 && group.getUsers().size() < 4);
    }

    public static Stream<Group> getSkipped(Stream<Group> groups) {
        return groups.skip(2);
    }

    public static Stream<Group> getDistinct(Stream<Group> groups) {
        return groups.distinct();
    }

    public static Stream<String> getMap(Stream<Group> groups) {
        return groups.map(group -> group.getName() + " has " + group.getUsers().size() + " users.");
    }

    public static Stream<Group> getPeek(Stream<Group> groups) {
        return groups.peek(group -> group.getUsers().removeIf(user -> user.getId() % 2 == 0));
    }

    public static Stream<Group> getLimit(Stream<Group> groups) {
        return groups.limit(3);
    }

    // which group has greater sum of user ids goes first
    public static Stream<Group> getSorted(Stream<Group> groups) {
        return groups.sorted((g1, g2) ->
                g2.getUsers().stream().mapToInt(user -> user.getId()).sum() -
                        g1.getUsers().stream().mapToInt(user -> user.getId()).sum()
        );
    }

    public static IntStream getMapToInt(Stream<Group> groups) {
        return groups.mapToInt(Group::getId);
    }

    // stream all users sorted by id
    public static Stream<User> getFlatMap(Stream<Group> groups) {
        return groups
                .flatMap(group -> group.getUsers().stream())
                .sorted((u1, u2) -> u1.getId() - u2.getId());
    }
}
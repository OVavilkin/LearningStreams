package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamCreation {
    public static Stream<Group> getStreamClassic() {
        return GroupFactory.createGroupsWithUsers(3, 10).stream();
    }

    public static Stream<Group> getStreamOf() {
        List<Group> groups = GroupFactory.createGroupsWithUsers(3, 10);
        return Stream.of(
                groups.get(0), groups.get(1), groups.get(2)
        );
    }

    public static Stream<Group> getStreamFromArray() {
        int groupNums = 3;
        int userNums = 10;
        Group[] groups = GroupFactory.createGroupsWithUsers(groupNums, userNums).toArray(new Group[groupNums]);
        return Arrays.stream(groups);
    }

    public static Stream<Group> getStreamFromBuilder() {
        List<Group> groups = GroupFactory.createGroupsWithUsers(3, 10);
        return Stream.<Group>builder()
                .add(groups.get(0))
                .add(groups.get(1))
                .add(groups.get(2))
                .build();
    }

    public static Stream<Group> getStreamFromIteration() {
        return Stream.iterate(GroupFactory.getGroupWithUsers(),
            group -> GroupFactory.getGroupWithUsers());
    }

    public static Stream<Group> getStreamFromGenerate() {
        return Stream.generate(() -> GroupFactory.getGroupWithUsers());
    }

}

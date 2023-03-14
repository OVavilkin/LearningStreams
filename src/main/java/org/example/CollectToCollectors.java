package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectToCollectors {
    public static void toCollection() {
        for( Group group: GroupFactory.get5x5().stream().collect(Collectors.toList())) {
            System.out.println(group);
        }
    }

    public static void toMap() {
        Map<String, String> map = GroupFactory.get5x5().stream()
                .collect(Collectors.toMap(
                        Group::getName,
                        g -> g.getUsers().stream().map(
                                u -> u.getName()).collect(Collectors.joining(","))));

        String longest = "";
        for(String groupName: map.keySet()) {
            if(groupName.length() > longest.length()) {
                longest = groupName;
            }
        }

        System.out.println(map.get(longest));
    }

    public static void toConcurentMap() {
        ConcurrentMap<Integer, String> cm = GroupFactory.get5x5().stream()
                .collect(Collectors.toConcurrentMap(
                        Group::getId,
                        g -> g.getUsers().stream().map(
                                u -> String.valueOf(u.getId())
                        ).collect(Collectors.joining(","))));
        cm.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static void partitioningBy() {
        Map<String, List<Group>> map = GroupFactory.get5x5().stream()
                .collect(Collectors.groupingBy(
                        g -> g.getId() % 2 == 0 ? "even" : "odd"
                ));
        for(String number: map.keySet()) {
            System.out.print(number + " : ");
            map.get(number).stream().map(g -> g.getId()).forEach(id -> System.out.print(id + " "));
            System.out.println();
        }
    }

    public static void groupingBy() {
        Map<Integer, List<Group>> map = GroupFactory.get5x5().stream()
                .collect(Collectors.groupingBy(
                        g -> g.getUsers().size()
                ));
        for(Map.Entry<Integer, List<Group>> entry: map.entrySet()) {
            String message = entry.getValue().stream().map(g -> String.valueOf(g.getId())).collect(Collectors.joining(", "));
            System.out.println("These groups have " + entry.getKey() + " users: " + message);
        }
    }

    public static void groupingByKeyMapperValueMapperCollectionSupplier() {
        List<Group> groups = GroupFactory.get5x5();
        Map<Integer, List<Integer>> map = groups.stream().flatMap(g -> g.getUsers().stream()).collect(Collectors.groupingBy(
                u -> u.getGroup().getId(),
                Collectors.mapping(
                        u -> u.getId(),
                        Collectors.toList()
                )
        ));
        map.entrySet().stream().forEach(entry -> {
                System.out.print("Group id " + entry.getKey() + " has users: ");
                System.out.print(entry.getValue().stream().map(value -> String.valueOf(value)).collect(Collectors.joining(",")));
                System.out.println();
        });
    }

    public static void averagingInt() {
        List<Group> groups = GroupFactory.get5x5();
        System.out.println(
                "sum of user ids divided by number of groups is: " +
                groups.stream()
                        .collect(Collectors.averagingInt(g -> g.getUsers().stream().mapToInt(User::getId).sum()))
        );
        int sum = 0;
        for(Group group: groups) {
            sum += group.getUsers().stream().mapToInt(User::getId).sum();
        }
        System.out.println("Check: " + sum/5);
    }

    public static void summarizingInt() {
        IntSummaryStatistics ist = GroupFactory.get5x5().stream().collect(
                Collectors.summarizingInt(g -> g.getName().length()));
        System.out.println("On Average, group name lenght is: " + ist.getAverage());
        System.out.println("Longest is " + ist.getMax());
        System.out.println("Total names are " + ist.getSum() + " long.");
    }

    public static void collectToCustomCollector() {
        List<Integer> userIds = GroupFactory.get5x5().stream().flatMap(g -> g.getUsers().stream()).collect(Collector.of(
                ArrayList::new,
                (list, user) -> list.add(user.getId()),
                (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        ));
        userIds.stream().forEach(id -> System.out.print(id + " "));
    }
}

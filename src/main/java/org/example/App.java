package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("StreamsCreation");
        System.out.println("#1: getStreamClassic");
        StreamCreation.getStreamClassic().forEach(g -> System.out.println(g.toString()));

        System.out.println("\n#2: getStreamOf");
        StreamCreation.getStreamOf().forEach(System.out::println);

        System.out.println("\n#3: getStreamFromArray");
        StreamCreation.getStreamFromArray().forEach(System.out::println);

        System.out.println("\n#4: getStreamFromBuilder");
        StreamCreation.getStreamFromBuilder().forEach(System.out::println);

        System.out.println("\n#5: getStreamFromIteration");
        StreamCreation.getStreamFromIteration().limit(4).forEach(System.out::println);

        System.out.println("\n#6: getStreamFromGenerate");
        StreamCreation.getStreamFromGenerate().limit(4).forEach(System.out::println);

        System.out.println("\n7: getFiltered");
        IntermediateOperations
                .getFiltered(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n8: getSkipped");
        IntermediateOperations
                .getSkipped(StreamCreation.getStreamFromGenerate().limit(5))
                .forEach(System.out::println);

        System.out.println("\n9: getDistinct");
        IntermediateOperations
                .getDistinct(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n10: getMap");
        IntermediateOperations
                .getMap(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n11: getPeek");
        IntermediateOperations
                .getPeek(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n12: getLimit");
        IntermediateOperations
                .getLimit(StreamCreation.getStreamFromGenerate())
                .forEach(System.out::println);

        System.out.println("\n13: getSorted");
        IntermediateOperations
                .getSorted(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n14: getMapToInt");
        IntermediateOperations
                .getMapToInt(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n15: getMapToInt");
        IntermediateOperations
                .getMapToInt(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n16: getFlatMap");
        IntermediateOperations
                .getFlatMap(StreamCreation.getStreamClassic())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n17: getFindFirst");
        System.out.println(TerminalOperations
                .getFindFirst(StreamCreation.getStreamClassic()));

        System.out.println("\n18: getFindAny");
        System.out.println(TerminalOperations
                .getFindAny(StreamCreation.getStreamClassic())
                .get());

        System.out.println("\n19: getCount");
        System.out.println(TerminalOperations
                .getCount(StreamCreation.getStreamClassic()));

        System.out.println("\n20: getAnyMatch");
        System.out.println(TerminalOperations
                .getAnyMatch(StreamCreation.getStreamClassic()));

        System.out.println("\n21: getNoneMatch");
        System.out.println(TerminalOperations
                .getNoneMatch(StreamCreation.getStreamClassic()));

        System.out.println("\n22: getAllMatch");
        System.out.println(TerminalOperations
                .getAllMatch(StreamCreation.getStreamClassic()));

        System.out.println("\n23: getMin");
        System.out.println(TerminalOperations
                .getMin(StreamCreation.getStreamClassic())
                .get());

        System.out.println("\n24: getMax");
        System.out.println(TerminalOperations
                .getMax(StreamCreation.getStreamClassic())
                .get());

        System.out.println("\n25: getForEachOrdered");
        TerminalOperations
                .getForEachOrdered(StreamCreation.getStreamClassic());

        System.out.println("\n26: getToArray");
        for(Group group: TerminalOperations
                .getToArray(StreamCreation.getStreamClassic())) {
            System.out.println("Group " + group.getId() + " has " + group.getUsers().size() + " users");
        }

        System.out.println("\n27: getReduceHardWay");
        TerminalOperations
                .getReduceHardWay(StreamCreation.getStreamClassic())
                .forEach(System.out::println);

        System.out.println("\n28: getReduceEasy");
        System.out.println(TerminalOperations
                .getReduceEasy(StreamCreation.getStreamClassic()));

        System.out.println("\n29: toCollection");
        CollectToCollectors.toCollection();

        System.out.println("\n30: toMap");
        CollectToCollectors.toMap();

        System.out.println("\n31: toConcurrentMap");
        CollectToCollectors.toConcurentMap();

        System.out.println("\n32: partitioningBy");
        CollectToCollectors.partitioningBy();

        System.out.println("\n33: partitioningBy");
        CollectToCollectors.groupingBy();

        System.out.println("\n34: groupingByKeyMapperValueMapperCollectionSupplier");
        CollectToCollectors.groupingByKeyMapperValueMapperCollectionSupplier();

        System.out.println("\n35: averagingInt");
        CollectToCollectors.averagingInt();

        System.out.println("\n36: summarizingInt");
        CollectToCollectors.summarizingInt();

        System.out.println("\n37: collectToCustomCollector");
        CollectToCollectors.collectToCustomCollector();
    }
}

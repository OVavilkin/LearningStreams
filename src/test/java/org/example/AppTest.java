package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Group group = GroupFactory.createGroup();
        assertTrue(group.getName().startsWith("Group #"));

        List<Group> groups = GroupFactory.createGroupsWithUsers(3, 10);
        assertTrue(groups.size() == 3);
        int usersCounted = 0;
        for(Group groupTmp: groups) {
            usersCounted += groupTmp.getUsers().size();
        }
        assertTrue(usersCounted == 10);

        Stream<Group> sGroup = StreamCreation.getStreamClassic();
        assertTrue(sGroup instanceof Stream);
        assertTrue(sGroup.findFirst().get().getName().startsWith("Group #"));
    }
}

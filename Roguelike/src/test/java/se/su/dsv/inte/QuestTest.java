package se.su.dsv.inte;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuestTest {
    @Test
    public void testCreateSimpleDeliverQuest() {
        // Sketch of desired interface.
        List<Object> objectives = null;
        Object reward = null;
        Quest quest = new Quest("Simple Title", "A short description", 1, objectives, reward);
    }
}
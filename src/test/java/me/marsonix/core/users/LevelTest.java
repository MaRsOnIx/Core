package me.marsonix.core.users;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.marsonix.core.exceptions.NumberLessThanZeroException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LevelTest {

    @Test
    public void checkLevelReached() throws NumberLessThanZeroException {
        Level level = new Level(0L);
        level.addExperience(20L);
        assertTrue(level.getLvl()==2);
    }

    @Test
    public void checkMoreLevelsReached() throws NumberLessThanZeroException {
        Level level = new Level(0L);
        level.addExperience(100L);
        assertTrue(level.getLvl()>2);
    }

    @Test
    public void checkEnteredExperienceLowerThanZero(){
        Level level = new Level(0L);
        assertThrows(NumberLessThanZeroException.class, () -> level.addExperience(-5));
    }
    @Test
    public void checkComparingWorksCorrectly(){
        List<Level> array = Arrays.asList(new Level(5L),
                new Level(5L),
                new Level(100L));
        Collections.sort(array);
        Level one = array.get(0);
        Level two = array.get(1);
        Level theree = array.get(2);

        assertTrue(one.getLvl()<=two.getLvl() && two.getLvl()<=theree.getLvl());
    }
    @Test
    public void checkObjectAutomaticallyUpdated(){
        Level level = new Level(1000L);
        assertTrue(level.getLvl()>1);
    }
    @Test
    public void checkTotalExperienceWorksCorectly(){
        Level lvl = new Level(100L);
        Level twoLvl = new LevelOverrided(100L);
        assertTrue(twoLvl.getLvl()>lvl.getLvl());
    }

    @Test
    public void checkCloning() throws NumberLessThanZeroException {
        Level level = new Level(1000L);
        Level clone = level.clone();
        level.addExperience(11L);
        assertFalse(level.equals(clone));

    }

    @Test
    public void testJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Level level = new Level(100);
        String s =objectMapper.writeValueAsString(level);
        System.out.println(s);
    }

}

class LevelOverrided extends Level {

    public LevelOverrided(long totalExperience) {
        super(totalExperience);
    }

    @Override
    public long getExperienceToNextLevel() {
        return super.getLvl();
    }
}
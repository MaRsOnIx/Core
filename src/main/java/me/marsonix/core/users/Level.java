package me.marsonix.core.users;

import me.marsonix.core.exceptions.NumberLessThanZeroException;

import java.util.Objects;

public class Level implements Comparable<Level>, Cloneable{

    private int lvl;
    private long experience;

    public Level(long totalExperience) {
        this.lvl = 1;
        this.experience = totalExperience;
        this.checkNextLevel();
    }

    public int getLvl() {
        return lvl;
    }

    public long getExperience() {
        return experience;
    }

    public void addExperience(long experience) throws NumberLessThanZeroException {
        if(experience<0)throw new NumberLessThanZeroException("Experience have to be greater than 0");
        this.experience+=experience;
        this.checkNextLevel();
    }

    public long getExperienceToNextLevel() {
        switch (this.lvl){
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            default:
                return 100;
        }
    }

    private void checkNextLevel(){
        if(this.experience<getExperienceToNextLevel())return;
        this.experience-=getExperienceToNextLevel();
        this.lvl++;
        this.checkNextLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return lvl == level.lvl &&
                experience == level.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lvl, experience);
    }


    @Override
    public int compareTo(Level o) {
        int lvlCompared = Integer.compare(this.lvl, o.lvl);
        return lvlCompared==0?Long.compare(this.experience, o.experience):lvlCompared;
    }

    @Override
    public String toString() {
        return "Level{" +
                "lvl=" + lvl +
                ", experience=" + experience +
                '}';
    }
    @Override
    public Level clone() {
        try {
            return (Level) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

}

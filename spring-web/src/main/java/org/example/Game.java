package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Game {

    private int score1;
    private int score2;

    @JsonIgnore
    private HashMap<String, Integer> stats = new HashMap<>();

    public Game() {
    }

    public Game(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public void raz(){
        score1 = 0;
        score2 = 0;
        stats.clear();
    }

    public void addStat(String navigator){
        stats.merge(navigator, 1, Integer::sum);
    }

    public void increment1(){
        score1++;
    }

    public void increment2(){
        score2++;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (score1 != game.score1) return false;
        return score2 == game.score2;
    }

    @Override
    public int hashCode() {
        int result = score1;
        result = 31 * result + score2;
        return result;
    }
}

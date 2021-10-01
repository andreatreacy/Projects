package c19718305;

// class used for storing the current game's health and score

public class Game {
    Assignment assignment;
    int health = 30;
    int score = 0;

    
    public Game(Assignment assignment) {
        this.assignment = assignment;
    }


    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}



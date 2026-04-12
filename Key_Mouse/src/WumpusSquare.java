public class WumpusSquare {
    private boolean gold;
    private boolean ladder;
    private boolean pit;
    private boolean breeze;
    private boolean wumpus;
    private boolean deadWumpus;
    private boolean stench;
    private boolean visited;

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean b) {
        gold = b;
    }

    public boolean isLadder() {
        return ladder;
    }

    public void setLadder(boolean b) {
        ladder = b;
    }

    public boolean isPit() {
        return pit;
    }

    public void setPit(boolean b) {
        pit = b;
    }

    public boolean isBreeze() {
        return breeze;
    }

    public void setBreeze(boolean b) {
        breeze = b;
    }

    public boolean isWumpus() {
        return wumpus;
    }

    public void setWumpus(boolean b) {
        wumpus = b;
    }

    public boolean isDeadWumpus() {
        return deadWumpus;
    }

    public void setDeadWumpus(boolean b) {
        deadWumpus = b;
    }

    public boolean isStench() {
        return stench;
    }

    public void setStench(boolean b) {
        stench = b;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean b) {
        visited = b;
    }

    public String toString() {
        if (wumpus && gold) {
            return "@";
        }
        if (deadWumpus && gold) {
            return "!";
        }
        if (wumpus) {
            return "W";
        }
        if (deadWumpus) {
            return "D";
        }
        if (ladder) {
            return "L";
        }
        if (pit) {
            return "P";
        }
        if (gold) {
            return "G";
        }
        return "*";
    }
}
public class WumpusSquare {
    private boolean pit, breeze, wumpus, deadWumpus, stench, gold, ladder, visited;

    public WumpusSquare() {
        pit = breeze = wumpus = deadWumpus = stench = gold = ladder = visited = false;
    }

    public boolean hasPit() { return pit; }
    public void setPit(boolean pit) { this.pit = pit; }

    public boolean hasBreeze() { return breeze; }
    public void setBreeze(boolean breeze) { this.breeze = breeze; }

    public boolean hasWumpus() { return wumpus; }
    public void setWumpus(boolean wumpus) { this.wumpus = wumpus; }

    public boolean isDeadWumpus() { return deadWumpus; }
    public void setDeadWumpus(boolean deadWumpus) { this.deadWumpus = deadWumpus; }

    public boolean hasStench() { return stench; }
    public void setStench(boolean stench) { this.stench = stench; }

    public boolean hasGold() { return gold; }
    public void setGold(boolean gold) { this.gold = gold; }

    public boolean hasLadder() { return ladder; }
    public void setLadder(boolean ladder) { this.ladder = ladder; }

    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
}
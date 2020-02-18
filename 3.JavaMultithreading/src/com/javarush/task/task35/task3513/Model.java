package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value ||
                        gameTiles[j][i].value == gameTiles[j - 1][i].value)
                    return true;
            }
        }
        return false;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                if (tile.isEmpty()) list.add(tile);
            }
        }
        return list;
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (!list.isEmpty())
            list.get((int) (list.size() * Math.random())).value = (Math.random() < 0.9 ? 2 : 4);
    }

    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        maxTile = 0;
        score = 0;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] saveTiles = new Tile[tiles.length][tiles.length];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                saveTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }

        previousStates.push(saveTiles);
        previousScores.push(score);
        isSaveNeeded = false;

    }

    void rollback() {
        if (!previousStates.empty()) gameTiles = previousStates.pop();
        if (!previousScores.empty()) score = previousScores.pop();
    }


    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                changes = true;
                compressTiles(tiles);
            }
        }
        return changes;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);

        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) || mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged){
            addTile();
            isSaveNeeded = true;
        }
    }

    public void up() {
        saveState(gameTiles);
        rotateToLeft();
        left();
        rotateToRight();
    }

    public void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToLeft();
    }

    public void right() {
        saveState(gameTiles);
        rotateMirror();
        left();
        rotateMirror();
    }


    public void rotateToRight() {
        Tile[][] result = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                result[j][gameTiles.length - i - 1] = gameTiles[i][j];
            }
        }
        gameTiles = result;
    }

    public void rotateToLeft() {
        Tile[][] result = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                result[gameTiles[i].length - j - 1][i] = gameTiles[i][j];
            }
        }
        gameTiles = result;
    }

    public void rotateMirror() {
        Tile[][] result = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                result[i][gameTiles.length - j - 1] = gameTiles[i][j];
            }
        }
        gameTiles = result;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] perStates = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value != perStates[i][j].value) return true;
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();

        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        queue.peek().getMove().move();
    }
}

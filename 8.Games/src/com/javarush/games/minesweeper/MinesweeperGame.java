package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private int countMinesOnField;

    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private int countFlags;
    private boolean isGameStopped;
    private int score;

    private int countClosedTiles = SIDE * SIDE;

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "WIN", Color.AQUA, 30);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER", Color.AQUA, 30);
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen | (countFlags == 0 & !gameObject.isFlag) | isGameStopped == true) {
        } else {
            if (gameObject.isFlag) {
                gameObject.isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            } else {
                gameObject.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            }
        }
    }

    private void openTile(int x, int y) {

        GameObject gameObject = gameField[y][x];

        if (gameObject.isOpen | gameObject.isFlag | isGameStopped == true) {
        } else {

            gameObject.isOpen = true;
            if (!gameObject.isMine) {
                score = score + 5;
            }
            setScore(score);
            countClosedTiles--;
            setCellColor(x, y, Color.GREEN);

            if (gameObject.isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                if (gameObject.countMineNeighbors == 0) {
                    setCellValue(x, y, "");

                    ArrayList<GameObject> neighborsList = getNeighbors(gameObject);
                    for (GameObject pair : neighborsList) {
                        if (!pair.isOpen) {
                            openTile(pair.x, pair.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, gameObject.countMineNeighbors);
                }
            }
        }

        if ((countClosedTiles == countMinesOnField) & !gameObject.isMine) {
            win();
        }
    }

    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped == true) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    // Список соседей переданной ячейки
    private ArrayList<GameObject> getNeighbors(GameObject gameObject) {
        ArrayList<GameObject> neighborsList = new ArrayList<>();
        int x = gameObject.x;
        int y = gameObject.y;

        for (int i = -1 + y; i <= y + 1; i++) {
            for (int j = -1 + x; j <= x + 1; j++) {
                try {
                    if (!(i == x & j == y)) {
                        neighborsList.add(gameField[i][j]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }

        }
        return neighborsList;
    }

    private void countMineNeighbors() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                if (!gameField[y][x].isMine) {
                    ArrayList<GameObject> getNeighbors = getNeighbors(gameField[y][x]);
                    for (GameObject pair : getNeighbors) {
                        if (pair.isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void createGame() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                setCellValue(x, y, "");
            }
        }

        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                boolean isMine = (getRandomNumber(10) == y) ? true : false;
                if (isMine) countMinesOnField++;
                gameField[x][y] = new GameObject(y, x, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
}



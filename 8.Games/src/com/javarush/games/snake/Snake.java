package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private int x;
    private int y;

    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        boolean doNothing = (this.direction == Direction.LEFT & snakeParts.get(0).x == snakeParts.get(1).x) ||
                (this.direction == Direction.RIGHT & snakeParts.get(0).x == snakeParts.get(1).x) ||
                (this.direction == Direction.UP & snakeParts.get(0).y == snakeParts.get(1).y) ||
                (this.direction == Direction.DOWN & snakeParts.get(0).y == snakeParts.get(1).y);

        if (!doNothing)
            if (!((this.direction == Direction.LEFT & direction == Direction.RIGHT) ||
                    (this.direction == Direction.RIGHT & direction == Direction.LEFT) ||
                    (this.direction == Direction.UP & direction == Direction.DOWN) ||
                    (this.direction == Direction.DOWN & direction == Direction.UP)))
                this.direction = direction;
    }

    public boolean isAlive = true;

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public GameObject createNewHead() {
        GameObject gameObject = null;
        switch (direction) {
            case LEFT:
                gameObject = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            case RIGHT:
                gameObject = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            case UP:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
            case DOWN:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;
        }
        return gameObject;
    }

    private List<GameObject> snakeParts = new ArrayList<>();

    public boolean checkCollision(GameObject gameObject) {
        boolean result = false;
        for (GameObject go : snakeParts) {
            result = (go.x == gameObject.x & go.y == gameObject.y);
            if (result)
                break;
        }
        return result;
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, i == 0 ? HEAD_SIGN : BODY_SIGN, !isAlive ? Color.RED : Color.BLACK, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT || (checkCollision(newHead)))
            isAlive = false;
        else {
            snakeParts.add(0, newHead);

            if (apple.x == newHead.x & apple.y == newHead.y)
                apple.isAlive = false;
            else
                removeTail();
        }
    }

    public int getLength() {
        return snakeParts.size();
    }

}

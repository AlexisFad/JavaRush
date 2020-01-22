package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
  private List<GameObject> snakeParts = new ArrayList<>();
  private final static String HEAD_SIGN = "\uD83D\uDC7E";
  private final static String BODY_SIGN = "\u26AB";
  public boolean isAlive = true;
  private Direction direction = Direction.LEFT;

  public Snake(int x, int y) {
      snakeParts.add(new GameObject(x, y));
      snakeParts.add(new GameObject(x + 1, y));
      snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game){
      Color color;
      if (isAlive) color = Color.BLACK;
      else color = Color.RED;

        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, color,75);
        for (int i = 1; i < snakeParts.size() ; i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, color,75);
        }
    }

   public void setDirection(Direction direction){
      if (this.direction == Direction.LEFT && direction == Direction.RIGHT) return;
      if (this.direction == Direction.RIGHT && direction == Direction.LEFT) return;
      if (this.direction == Direction.UP && direction == Direction.DOWN) return;
      if (this.direction == Direction.DOWN && direction == Direction.UP) return;

      if (this.direction == Direction.LEFT && (snakeParts.get(0).x == snakeParts.get(1).x)) return;
      if (this.direction == Direction.RIGHT && (snakeParts.get(0).x == snakeParts.get(1).x)) return;
      if (this.direction == Direction.UP && (snakeParts.get(0).y == snakeParts.get(1).y)) return;
      if (this.direction == Direction.DOWN && (snakeParts.get(0).y == snakeParts.get(1).y)) return;

      else this.direction = direction;
    }

    public void move(Apple apple){
      GameObject newHead = createNewHead();
      if (newHead.x >= SnakeGame.WIDTH || newHead.x < 0 || newHead.y >= SnakeGame.WIDTH || newHead.y < 0) isAlive = false;
      else if (newHead.x >= SnakeGame.HEIGHT || newHead.y >= SnakeGame.HEIGHT) isAlive = false;
      else if (newHead.x == apple.x && newHead.y == apple.y){
          if (checkCollision(newHead)) {
              isAlive = false;
              return;
          }
          else {
          snakeParts.add(0, newHead);
          apple.isAlive = false;}
      }
      else {
          if (checkCollision(newHead)) {
              isAlive = false;
              return;
          }
          else {
          snakeParts.add(0, newHead);
          removeTail();}
      }

    }

   public GameObject createNewHead(){
      if (direction == Direction.LEFT)  return new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
      if (direction == Direction.RIGHT) return new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
      if (direction == Direction.DOWN)  return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
      if (direction == Direction.UP)    return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);

      return snakeParts.get(0);
    }

    public void removeTail(){
      snakeParts.remove(snakeParts.get(snakeParts.size()-1));
    }

   public boolean checkCollision(GameObject gameObject){
       for (int i = 0; i < snakeParts.size() ; i++) {
           if (snakeParts.get(i).y == gameObject.y && snakeParts.get(i).x == gameObject.x) return true;
       }
      return false;
    }

    public int getLength(){
      return snakeParts.size();
    }

}

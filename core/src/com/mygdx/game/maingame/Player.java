package com.mygdx.game.maingame;

import static com.badlogic.gdx.math.MathUtils.clamp;
import static com.badlogic.gdx.math.MathUtils.sinDeg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
  private static final float MAX_SPEED = 400;
  private static final float ACCELERATION = 20f;
  private static final float DECELERATION = 5f;
  private static final float ROTATE_SPEED = 200f;

  private float speed = 0;
  private float angle = 0;

  private float x;
  private float y;

  public void update(float delta) {
    decelerate(delta);

    if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
      increaseSpeed(delta);
    }

    if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      decreaseSpeed(delta);
    }

    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      rotateLeft(delta);
    }

    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      rotateRight(delta);
    }

    updatePosition(delta);
  }

  private void rotateRight(float delta) {
    this.angle -= delta * ROTATE_SPEED;
  }

  private void rotateLeft(float delta) {
    this.angle += delta * ROTATE_SPEED;
  }

  private void updatePosition(float delta) {
    this.x += speed * delta;
    this.y += speed * delta * sinDeg(angle);
  }

  private void decelerate(float delta) {
    speed = clamp(speed - (DECELERATION * delta), 0, MAX_SPEED);
  }

  public void increaseSpeed(float delta) {
    speed = clamp(speed + (ACCELERATION * delta), 0, MAX_SPEED);
  }

  public void decreaseSpeed(float delta) {
    speed = clamp(speed - (ACCELERATION * delta), 0, MAX_SPEED);
  }



  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getAngle() {
    return angle;
  }
}

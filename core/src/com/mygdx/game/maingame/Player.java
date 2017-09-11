package com.mygdx.game.maingame;

import static com.badlogic.gdx.math.MathUtils.clamp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
  private static final float MAX_SPEED = 400;
  private static final float ACCELERATION = 20f;
  private static final float DECELERATION = 5f;

  private float speed = 0;
  private float x;
  private float y;

  public void update(float delta) {
    decelerate(delta);

    if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      increaseSpeed(delta);
    }

    updatePosition(delta);
  }

  private void updatePosition(float delta) {
    this.x += speed * delta;
  }

  private void decelerate(float delta) {
    speed = clamp(speed - (DECELERATION * delta), 0, MAX_SPEED);
  }

  public void increaseSpeed(float delta) {
    speed = clamp(speed + (ACCELERATION * delta), 0, MAX_SPEED);
  }


  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }
}

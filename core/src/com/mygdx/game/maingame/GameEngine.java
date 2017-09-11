package com.mygdx.game.maingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import javax.inject.Inject;

public class GameEngine {
  private Player player;
  private Actor playerActor;

  @Inject
  public GameEngine(final Player player) {
    this.player = player;
    playerActor = new Image(new Texture(Gdx.files.internal("player/ef2000.png")));
  }

  public void update(float delta) {
    player.update(delta);

    playerActor.setPosition(player.getX(), player.getY());
  }

  public Actor getPlayer() {
    return playerActor;
  }
}

package com.mygdx.game.maingame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AdvGame;

import javax.inject.Inject;

public class MainGameScreen extends ScreenAdapter {
  private final GameEngine gameEngine;
  private Stage stage;

  @Inject
  public MainGameScreen(final GameEngine gameEngine) {
    this.gameEngine = gameEngine;

    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    stage = new Stage(new FitViewport(width, height));
    stage.addActor(this.gameEngine.getPlayer());

//    Gdx.input.setInputProcessor(playerInput);
//    final InputMultiplexer inputMultiplexer = new InputMultiplexer();

  }

  @Override
  public void render(final float delta) {
    gameEngine.update(delta);

    Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.draw();
  }

  @Override
  public void resize (int width, int height) {
    stage.getViewport().update(width, height, true);
  }
}

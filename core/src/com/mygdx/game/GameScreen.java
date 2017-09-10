package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.inject.Inject;

public class GameScreen extends ScreenAdapter {
  private Stage stage;
  private Viewport viewport;

  @Inject
  public GameScreen(final AdvGame game) {
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    this.viewport = new FitViewport(width, height);
    stage = new Stage(viewport);
    stage.addActor(new Image(new Texture(Gdx.files.internal("player/ef2000.png"))));

    final InputMultiplexer inputMultiplexer = new InputMultiplexer();
    Gdx.input.setInputProcessor(inputMultiplexer);
  }

  @Override
  public void render(final float delta) {
    Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.draw();
  }

  @Override
  public void resize (int width, int height) {
    stage.getViewport().update(width, height, true);
  }
}

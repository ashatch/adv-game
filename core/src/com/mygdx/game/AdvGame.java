package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class AdvGame extends ApplicationAdapter {
  private Stage stage;
  private Viewport viewport;

  @Override
  public void create() {
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    this.viewport = new FitViewport(width, height);
    stage = new Stage(viewport);
    stage.addActor(new Image(new Texture("ef2000.png")));
  }

  @Override
  public void render() {
    Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.draw();
  }

  @Override
  public void resize (int width, int height) {
    stage.getViewport().update(width, height, true);
  }
}

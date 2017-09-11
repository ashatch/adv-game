package com.mygdx.game.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import javax.inject.Inject;

public class MainMenuScreen extends ScreenAdapter {

  private final Stage stage;
  private final BitmapFont font;
  private final OrthographicCamera camera;
  private final MainMenuInput input;

  @Inject
  public MainMenuScreen(final MainMenuInput input) {
    this.input = input;

    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    this.font = new BitmapFont(Gdx.files.internal("fonts/lato_20/lato_20_bright.fnt"));
    this.camera = new OrthographicCamera(width, height);
    stage = new Stage(new FitViewport(width, height, camera));
  }

  @Override
  public void show () {
    Gdx.input.setInputProcessor(input);
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    this.camera.update();

    final Batch batch = stage.getBatch();
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    this.font.draw(batch, "Welcome", 100, 150);
    this.font.draw(batch, "Tap anywhere to begin!", 100, 100);
    batch.end();
  }

  @Override
  public void resize (int width, int height) {
    stage.getViewport().update(width, height, true);
  }
}

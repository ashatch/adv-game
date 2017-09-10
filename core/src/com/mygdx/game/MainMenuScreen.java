package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import javax.inject.Inject;

public class MainMenuScreen extends ScreenAdapter {

  private final AdvGame game;
  private final FitViewport viewport;
  private final Stage stage;
  private final BitmapFont font;
  private GameScreen gameScreen;

  @Inject
  public MainMenuScreen(final AdvGame game,
                        final GameScreen gameScreen) {
    this.game = game;
    this.gameScreen = gameScreen;

    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
    this.font = new BitmapFont(Gdx.files.internal("fonts/lato_20/lato_20_bright.fnt"));
    this.viewport = new FitViewport(width, height);
    stage = new Stage(viewport);
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//    camera.update();
//    game.batch.setProjectionMatrix(camera.combined);

    final Batch batch = stage.getBatch();

    batch.begin();
    this.font.draw(batch, "Welcome", 100, 150);
    this.font.draw(batch, "Tap anywhere to begin!", 100, 100);
    batch.end();

    if (Gdx.input.isTouched()) {
      game.setScreen(gameScreen);
      dispose();
    }
  }

  @Override
  public void resize (int width, int height) {
    stage.getViewport().update(width, height, true);
  }
}

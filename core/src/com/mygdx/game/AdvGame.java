package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.google.inject.Guice;

import com.badlogic.gdx.Game;
import com.mygdx.game.mainmenu.MainMenuScreen;

public class AdvGame extends Game {
  @Override
  public void create() {
    final MainMenuScreen mainMenuScreen = Guice.createInjector(new AdvGameModule(this))
        .getInstance(MainMenuScreen.class);

    this.setScreen(mainMenuScreen);
  }

  @Override
  public void render() {
    super.render();
  }

  public void setScreen(final Screen screen, boolean dispose) {
    if (this.getScreen() != null && dispose) {
      this.getScreen().dispose();
    }
    this.setScreen(screen);
  }
}

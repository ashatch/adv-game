package com.mygdx.game;

import com.google.inject.Guice;

import com.badlogic.gdx.Game;

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
}

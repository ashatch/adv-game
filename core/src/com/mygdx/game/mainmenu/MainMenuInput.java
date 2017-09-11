package com.mygdx.game.mainmenu;

import com.badlogic.gdx.InputAdapter;

import javax.inject.Inject;

public class MainMenuInput extends InputAdapter {


  private final MainMenuController controller;

  @Inject
  public MainMenuInput(final MainMenuController controller) {
    this.controller = controller;
  }

  public boolean touchUp (final int screenX,
                          final int screenY,
                          final int pointer,
                          final int button) {
    controller.startGame();
    return true;
  }
}

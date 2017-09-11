package com.mygdx.game.mainmenu;

import com.mygdx.game.AdvGame;
import com.mygdx.game.maingame.MainGameScreen;

import javax.inject.Inject;

public class MainMenuController {

  private final AdvGame game;
  private final MainGameScreen mainGameScreen;

  @Inject
  public MainMenuController(final AdvGame game,
                            final MainGameScreen mainGameScreen) {
    this.game = game;
    this.mainGameScreen = mainGameScreen;
  }

  public void startGame() {
    game.setScreen(this.mainGameScreen);
  }
}

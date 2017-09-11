package com.mygdx.game.mainmenu;

import com.mygdx.game.AdvGame;
import com.mygdx.game.GameScreen;

import javax.inject.Inject;

public class MainMenuController {

  private final AdvGame game;
  private final GameScreen gameScreen;

  @Inject
  public MainMenuController(final AdvGame game,
                            final GameScreen gameScreen) {
    this.game = game;
    this.gameScreen = gameScreen;
  }

  public void startGame() {
    game.setScreen(this.gameScreen);
  }
}

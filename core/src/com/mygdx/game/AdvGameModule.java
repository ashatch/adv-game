package com.mygdx.game;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class AdvGameModule extends AbstractModule {
  private final AdvGame gameInstance;

  public AdvGameModule(AdvGame gameInstance) {
    this.gameInstance = gameInstance;
  }

  @Override
  protected void configure() {}

  @Provides
  public AdvGame advGame() {
    return gameInstance;
  }
}

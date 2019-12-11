package nl.gerardvdbosch.asteroidsgame.gamestates

import nl.gerardvdbosch.asteroidsgame.managers.GameStateManager

abstract class GameState(var gameStateManager: GameStateManager?) {

     public abstract fun init();
     public abstract fun update(dt: Float)
     public abstract fun draw()
     public abstract fun handleInput()
     public abstract fun dispose()

}
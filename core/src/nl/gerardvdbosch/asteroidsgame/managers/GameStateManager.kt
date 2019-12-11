package nl.gerardvdbosch.asteroidsgame.managers

import nl.gerardvdbosch.asteroidsgame.gamestates.*
import nl.gerardvdbosch.asteroidsgame.gamestates.enums.State
import nl.gerardvdbosch.asteroidsgame.gamestates.impl.MenuState
import nl.gerardvdbosch.asteroidsgame.gamestates.impl.PlayState

class GameStateManager() {
    var gameState: GameState? = null

    init {
        State.PLAY.setState()
    }

    private fun State.setState() {
        return when(this) {
            State.MENU -> gameState = MenuState(this@GameStateManager)
            State.PLAY -> gameState = PlayState(this@GameStateManager)
        }
    }

    fun update(dt: Float){
        gameState?.update(dt)
    }

    fun draw(){
        gameState?.draw()
    }

}
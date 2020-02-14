package nl.gerardvdbosch.asteroidsgame.gamestates.impl

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import nl.gerardvdbosch.asteroidsgame.entities.impl.PlayerEntity
import nl.gerardvdbosch.asteroidsgame.gamestates.GameState
import nl.gerardvdbosch.asteroidsgame.managers.utils.GameKeys
import nl.gerardvdbosch.asteroidsgame.managers.GameStateManager

class PlayState(gameStateManager: GameStateManager) : GameState(gameStateManager) {

    var player : PlayerEntity = PlayerEntity()
    var sr : ShapeRenderer = ShapeRenderer()

    override fun init() {
        init()
    }

    override fun update(dt: Float) {
        handleInput()
        player.update(dt)
    }

    override fun draw() {
        player.draw(sr)
    }

    override fun handleInput() {
        player.setLeft(GameKeys.isKeyDown(GameKeys.LEFT)!!)
        player.setRight(GameKeys.isKeyDown(GameKeys.RIGHT)!!)
        player.setUp(GameKeys.isKeyDown(GameKeys.UP)!!)
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
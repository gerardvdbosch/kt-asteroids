package nl.gerardvdbosch.asteroidsgame

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import nl.gerardvdbosch.asteroidsgame.managers.GameInputManager
import nl.gerardvdbosch.asteroidsgame.managers.utils.GameKeys
import nl.gerardvdbosch.asteroidsgame.managers.GameStateManager

class KotlinGame : ApplicationAdapter() {
    var batch: SpriteBatch? = null
    var camera: OrthographicCamera? = null
    private var gameStateManager: GameStateManager? = null

    companion object {
        var HEIGHT : Float? = null
        var WIDTH : Float? = null
    }

    override fun create() {
        batch = SpriteBatch()
        WIDTH = Gdx.graphics.width.toFloat()
        HEIGHT = Gdx.graphics.height.toFloat()
        camera = OrthographicCamera(WIDTH!!, HEIGHT!!)
        gameStateManager = GameStateManager()
        camera!!.translate(WIDTH!!/2, HEIGHT!!/2)
        camera!!.update()

        Gdx.input.inputProcessor = GameInputManager()
    }

    override fun render() {
        Gdx.gl.glClearColor(0F, 0F,0F,0F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        gameStateManager?.update(Gdx.graphics.deltaTime)
        gameStateManager?.draw()

        GameKeys.update()
        batch!!.begin()
        batch!!.end()


    }

    override fun dispose() {
        batch!!.dispose()
    }
}
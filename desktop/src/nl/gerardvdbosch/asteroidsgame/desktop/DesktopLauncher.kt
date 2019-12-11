package nl.gerardvdbosch.asteroidsgame.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import nl.gerardvdbosch.asteroidsgame.KotlinGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.title = "Asteriods"
        config.height = 400
        config.width = 500
        LwjglApplication(KotlinGame(), config)
    }
}
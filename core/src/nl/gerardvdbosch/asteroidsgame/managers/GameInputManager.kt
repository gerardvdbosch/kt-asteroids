package nl.gerardvdbosch.asteroidsgame.managers

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import nl.gerardvdbosch.asteroidsgame.managers.utils.GameKeys

class GameInputManager: InputAdapter() {

    override fun keyDown(keycode: Int): Boolean {
        if(keycode == Input.Keys.UP){
            GameKeys.setKey(GameKeys.UP, true)
        }
        if(keycode == Input.Keys.LEFT){
            GameKeys.setKey(GameKeys.LEFT, true)
        }
        if(keycode == Input.Keys.RIGHT){
            GameKeys.setKey(GameKeys.RIGHT, true)
        }
        if(keycode == Input.Keys.DOWN){
            GameKeys.setKey(GameKeys.DOWN, true)
        }
        return super.keyDown(keycode)
    }

    override fun keyUp(keycode: Int): Boolean {
        if(keycode == Input.Keys.UP){
            GameKeys.setKey(GameKeys.UP, false)
        }
        if(keycode == Input.Keys.LEFT){
            GameKeys.setKey(GameKeys.LEFT, false)
        }
        if(keycode == Input.Keys.RIGHT){
            GameKeys.setKey(GameKeys.RIGHT, false)
        }
        if(keycode == Input.Keys.DOWN){
            GameKeys.setKey(GameKeys.DOWN, false)
        }
        return super.keyUp(keycode)
    }
}
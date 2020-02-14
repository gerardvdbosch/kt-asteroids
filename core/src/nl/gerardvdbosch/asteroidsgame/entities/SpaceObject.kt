package nl.gerardvdbosch.asteroidsgame.entities

import nl.gerardvdbosch.asteroidsgame.KotlinGame

abstract class SpaceObject {

    var x : Float = 0f
    var y : Float = 0f

    var dx : Float = 0f
    var dy : Float = 0f

    var radians : Float = 0f
    var speed : Float = 0f
    var rotationSpeed : Float = 0f

    var shapex : FloatArray? = null
    var shapey : FloatArray? = null

    fun wrap(){
        if(x < 0) x = KotlinGame.WIDTH!!
        if(x > KotlinGame.WIDTH!!) x = 0f
        if(y < 0) y = KotlinGame.HEIGHT!!
        if(y > KotlinGame.HEIGHT!!) y = 0f
    }
}
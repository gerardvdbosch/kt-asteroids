package nl.gerardvdbosch.asteroidsgame.entities.impl

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils
import nl.gerardvdbosch.asteroidsgame.KotlinGame
import nl.gerardvdbosch.asteroidsgame.entities.SpaceObject
import java.util.*
import kotlin.math.sqrt

class PlayerEntity : SpaceObject() {

    var playerId : String = UUID.randomUUID().toString()
    var left : Boolean? = null
    var right : Boolean? = null
    var up: Boolean? = null

    var maxSpeed: Float? = null
    var acceleration: Float? = null
    var deceleration: Float? = null

    init {
        x = 250f
        y = 200f

        maxSpeed = 4f
        acceleration = 50f
        deceleration = 2f

        rotationSpeed = 4f
        speed = 1f


        shapex = FloatArray(4)
        shapey = FloatArray(4)

        radians = 3.1415f / 2
    }

    fun setShape() {
        shapex?.set(0, x.plus(MathUtils.cos(radians) * 8))
        shapey?.set(0, y.plus(MathUtils.sin(radians) * 8))

        shapex?.set(1, x.plus(MathUtils.cos(radians - 4 * 3.1415f / 5) * 8))
        shapey?.set(1, y.plus(MathUtils.sin(radians - 4 * 3.1415f / 5) * 8))

        shapex?.set(2, x.plus(MathUtils.cos(radians + 3.1415f) * 5))
        shapey?.set(2, y.plus(MathUtils.sin(radians + 3.1415f) * 5))

        shapex?.set(3, x.plus(MathUtils.cos(radians + 4 * 3.1415f / 5) * 8))
        shapey?.set(3, y.plus(MathUtils.sin(radians + 4 * 3.1415f / 5) * 8))
    }

    fun setLeft(b: Boolean) {
        left = b
    }

    fun setRight(b: Boolean) {
        right = b
    }

    fun setUp(b: Boolean) {
        up = b
    }

    fun update(dt: Float) {
        if(left == true){
            radians += rotationSpeed.times(dt)
        } else if(right == true){
            radians -= rotationSpeed.times(dt)
        }

        if(up == true){
            dx += (MathUtils.cos(radians) * acceleration!! * dt)
            dy += (MathUtils.sin(radians) * acceleration!! * dt)
        }
        val vec = sqrt(dx * dx + dy * dy)
        if(vec > 0) {
            dx -= (dx / vec) * deceleration!! * dt
            dy -= (dy / vec) * deceleration!! * dt
        }
        if (vec > maxSpeed!!) {
            dx = (dx / vec) * maxSpeed!!
            dy = (dy / vec) * maxSpeed!!
        }

        x = x.plus(dx)
        y = y.plus(dy)

        setShape()

        wrap()
    }

    fun draw(sr: ShapeRenderer){
        sr.color = com.badlogic.gdx.graphics.Color.CYAN

        sr.begin(ShapeRenderer.ShapeType.Line)

        var i = 0
        var j = shapex!!.size.minus(1)
        while(i < shapex!!.size){
            sr.line(shapex?.get(i)!!, shapey?.get(i)!!, shapex?.get(j)!!, shapey?.get(j)!!)
            j = i++
        }
        sr.end()
    }

}

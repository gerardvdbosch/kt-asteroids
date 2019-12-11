package nl.gerardvdbosch.asteroidsgame.managers.utils

class GameKeys {
    companion object {
        var NUMKEYS = 4
        var UP = 0
        var DOWN = 1
        var LEFT = 2
        var RIGHT = 3

        private var keys: BooleanArray? = BooleanArray(NUMKEYS)
        private var pkeys: BooleanArray? = BooleanArray(NUMKEYS)

        fun update() {
            pkeys = keys?.clone()
        }

        fun setKey(k: Int, b: Boolean) {
            keys?.set(k, b)
        }

        fun isKeyDown(k: Int): Boolean? {
            return keys?.get(k)
        }

        fun isPressed(k: Int): Boolean? {
            return keys?.get(k)!! && !pkeys?.get(k)!!
        }

    }

}
package nl.gerardvdbosch.asteroidsgame.server.manager

import nl.gerardvdbosch.asteroidsgame.entities.impl.PlayerEntity
import java.util.concurrent.ConcurrentHashMap

object ServerManager {

    private final val playerList = ConcurrentHashMap<String, PlayerEntity>()

    fun addPlayer(pid: String, player: PlayerEntity){
        playerList[pid] = player
    }

    fun getPlayer(pid: String): PlayerEntity? {
        return playerList[pid]
    }

}
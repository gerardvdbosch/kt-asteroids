package nl.gerardvdbosch.asteroidsgame.server.processors

import nl.gerardvdbosch.asteroidsgame.entities.impl.PlayerEntity
import nl.gerardvdbosch.asteroidsgame.server.manager.ServerManager
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.LoginPacket
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.PlayerPacket

class PacketProcessor(val serverManager: ServerManager) {

    fun handlePlayerPacket(packet: PlayerPacket){

    }

    fun handleLoginPacket(packet: LoginPacket){
        serverManager.addPlayer("1", PlayerEntity())
    }

}
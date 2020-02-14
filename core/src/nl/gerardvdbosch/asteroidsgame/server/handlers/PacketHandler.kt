package nl.gerardvdbosch.asteroidsgame.server.handlers

import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import nl.gerardvdbosch.asteroidsgame.server.manager.ServerManager
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.LoginPacket
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.PlayerPacket
import nl.gerardvdbosch.asteroidsgame.server.processors.PacketProcessor

class PacketHandler(serverManager: ServerManager) : Listener() {

    private val packetProcessor: PacketProcessor = PacketProcessor(serverManager)

    override fun connected(connection: Connection?) {
        super.connected(connection)
    }

    override fun disconnected(connection: Connection?) {
        super.disconnected(connection)
    }

    override fun received(connection: Connection?, obj : Any?) {
        super.received(connection, obj)
        when(obj){
            is PlayerPacket -> packetProcessor.handlePlayerPacket(obj)
            is LoginPacket -> packetProcessor.handleLoginPacket(obj)
        }
    }
}

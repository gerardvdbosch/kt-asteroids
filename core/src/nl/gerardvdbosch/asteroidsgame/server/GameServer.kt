package nl.gerardvdbosch.asteroidsgame.server

import com.badlogic.gdx.ApplicationAdapter
import com.esotericsoftware.kryonet.EndPoint
import com.esotericsoftware.kryonet.Server
import nl.gerardvdbosch.asteroidsgame.server.handlers.PacketHandler
import nl.gerardvdbosch.asteroidsgame.server.manager.ServerManager
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.LoginPacket


class GameServer : ApplicationAdapter() {

    companion object {
        private val server: Server = Server()
        private val serverManager: ServerManager = ServerManager

        init{
            register(server)
            server.bind(8080)
            server.addListener(PacketHandler(serverManager))
        }

        private fun register(endPoint: EndPoint) {
            val kyro = endPoint.kryo
            kyro.register(LoginPacket::class.java)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            server.run()
        }
    }

}
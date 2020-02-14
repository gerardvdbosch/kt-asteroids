package nl.gerardvdbosch.asteroidsgame

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryonet.Client
import com.esotericsoftware.kryonet.EndPoint
import nl.gerardvdbosch.asteroidsgame.server.handlers.PacketHandler
import nl.gerardvdbosch.asteroidsgame.server.manager.ServerManager
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.LoginPacket
import nl.gerardvdbosch.asteroidsgame.server.packets.impl.PlayerPacket

class GameClient() {

    companion object{
        val client: Client = Client()

        init {
            register(client)
        }

        fun register(endpoint: EndPoint){
            val kryo: Kryo = endpoint.kryo
            kryo.register(LoginPacket::class.java)
            kryo.register(PlayerPacket::class.java)
        }

        fun run(){
            client.start()
            // client.addListener(PacketHandler(ServerManager()))
            client.connect(2500, "localhost", 8080)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            this.run()
            while(true){
                client.sendTCP(LoginPacket())
                Thread.sleep(1000)
            }
        }
    }


}
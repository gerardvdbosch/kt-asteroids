package nl.gerardvdbosch.asteroidsgame.server.packets.impl

import nl.gerardvdbosch.asteroidsgame.server.packets.Packet
import java.util.*

class PlayerPacket : Packet {

    override val leadingByte: Byte = 0x02
    var playerId: String = UUID.randomUUID().toString()

}
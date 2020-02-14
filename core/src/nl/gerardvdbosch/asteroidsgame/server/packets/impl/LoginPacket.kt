package nl.gerardvdbosch.asteroidsgame.server.packets.impl

import nl.gerardvdbosch.asteroidsgame.server.packets.Packet

class LoginPacket : Packet {

    override val leadingByte: Byte = 0x01

}

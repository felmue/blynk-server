package cc.blynk.common.handlers.common.encoders;

import cc.blynk.common.enums.Command;
import cc.blynk.common.enums.Response;
import cc.blynk.common.model.messages.MessageBase;
import cc.blynk.common.model.messages.ResponseWithBodyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Encodes java message into a bytes array.
 *
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 2/1/2015.
 */
public class MessageEncoder extends MessageToByteEncoder<MessageBase> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageBase message, ByteBuf out) throws Exception {
        out.writeByte(message.command);
        out.writeShort(message.id);

        if (message.command == Command.RESPONSE) {
            out.writeShort(message.length);
            if (message.length == Response.DEVICE_WENT_OFFLINE_2) {
                out.writeInt(((ResponseWithBodyMessage) message).dashId);
            }
        } else {
            byte[] body = message.getBytes();
            out.writeShort(body.length);
            if (body.length > 0) {
                out.writeBytes(body);
            }
        }
    }
}

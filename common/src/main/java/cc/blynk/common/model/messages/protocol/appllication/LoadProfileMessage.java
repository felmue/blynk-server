package cc.blynk.common.model.messages.protocol.appllication;

import cc.blynk.common.model.messages.StringMessage;

import static cc.blynk.common.enums.Command.LOAD_PROFILE;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 2/1/2015.
 */
@Deprecated
public class LoadProfileMessage extends StringMessage {

    public LoadProfileMessage(int messageId, String body) {
        super(messageId, LOAD_PROFILE, body.length(), body);
    }

    @Override
    public String toString() {
        return "LoadProfileMessage{" + super.toString() + "}";
    }
}

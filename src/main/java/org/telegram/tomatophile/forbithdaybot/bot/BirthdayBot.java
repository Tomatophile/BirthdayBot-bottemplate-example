package org.telegram.tomatophile.forbithdaybot.bot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.tomatophile.bottemplate.AbstractTelegramBot;
import org.telegram.tomatophile.bottemplate.receiver.UpdateReceiver;

@Getter
@Setter
@Component
public class BirthdayBot extends AbstractTelegramBot {
    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${telegram.bot.username}")
    private String botUsername;

    public BirthdayBot(UpdateReceiver updateReceiver) {
        super(updateReceiver);
    }
}

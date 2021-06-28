package org.telegram.tomatophile.forbithdaybot;

import org.telegram.tomatophile.bottemplate.TelegramApplication;
import org.telegram.tomatophile.bottemplate.TelegramBotApplication;

@TelegramBotApplication
public class BirthdayApp {
    public static void main(String[] args) {
        TelegramApplication.run(BirthdayApp.class, args);
    }
}

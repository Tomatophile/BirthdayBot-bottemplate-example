package org.telegram.tomatophile.forbithdaybot.bot.processed.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.tomatophile.bottemplate.keyboard.ReplyKeyboardMarkupBuilder;
import org.telegram.tomatophile.bottemplate.processed.command.Command;
import org.telegram.tomatophile.bottemplate.processed.text.Text;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command {
    @Getter
    private final String command = "/start";

    private final List<Text> texts;

    @Override
    public List<PartialBotApiMethod<Message>> process(String chatId) {
        var keyboard = ReplyKeyboardMarkupBuilder.create(chatId);

        keyboard.setText("Привет! \nАртёму похоже слишком лень, чтобы поздравлять тебя самому (*пидор*). Поэтому я здесь, чтобы сделать это за него!" +
                " Выбери, какое поздравление ты хочешь получить: ");

        for (var i = 0; i < texts.size(); i++) {
            keyboard.addButton(texts.get(i).getText());
            if (i == texts.size() - 1) {
                break;
            }
            keyboard.nextRow();
        }

        return List.of(keyboard.build());
    }
}

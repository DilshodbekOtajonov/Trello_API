package com.example.trelloApi.configs.logger.sender;

import org.springframework.scheduling.annotation.Async;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/5/22 9:25 AM (Monday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

public class MyBot extends TelegramLongPollingBot {
    private static Set<String> chatIds = new HashSet<>(Set.of("1138427488")); //Chat ids are automatically added to hashset but you can save them at database of your choice.

    @Override
    public String getBotToken() {
        return ""; // enter bot token. You can take it from botFather on telegram.
    }

    @Override
    public void onUpdateReceived(Update update) {
        chatIds.add(update.getMessage().getChatId().toString());
    }

    @Override
    public String getBotUsername() {
        return "DilshodbeksBot";
    }

    public void SendMessage(String message) {
        for (String chatId : chatIds) {
            SendMessage sendMessage = new SendMessage(chatId, message);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

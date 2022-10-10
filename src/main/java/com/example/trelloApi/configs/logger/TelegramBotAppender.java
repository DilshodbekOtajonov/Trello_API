package com.example.trelloApi.configs.logger;

import com.example.trelloApi.configs.logger.sender.MyBot;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/5/22 8:54 AM (Monday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Plugin(
        name = "TelegramBotAppender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE)
public class TelegramBotAppender extends AbstractAppender {
    private final MyBot myBot = new MyBot();

    protected TelegramBotAppender(String name, Filter filter) {
        super(name, filter, PatternLayout.newBuilder().build(), true, null);
    }

    @PluginFactory
    public static TelegramBotAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter
    ) {
        return new TelegramBotAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        if (event.getLevel().isMoreSpecificThan(Level.ERROR))
            myBot.SendMessage(
                    event.getSource().getMethodName() + "\n"
                            + event.getSource().getClassName() + "\n"
                            + event.getMessage().getFormattedMessage()
            );
    }
}


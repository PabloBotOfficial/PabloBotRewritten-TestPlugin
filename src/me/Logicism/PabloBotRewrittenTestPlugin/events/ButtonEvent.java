package me.Logicism.PabloBotRewrittenTestPlugin.events;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ButtonEvent extends ListenerAdapter {

    @Override
    public void onButtonClick(@NotNull ButtonClickEvent event) {
        if (event.getComponentId().equals("testplugin_button1")) {
            event.reply("You clicked on a primary button!").queue();
        } else if (event.getComponentId().equals("testplugin_button2")) {
            event.reply("You clicked on a secondary button!").queue();
        } else if (event.getComponentId().equals("testplugin_button3")) {
            event.reply("You clicked on a danger button!").queue();
        } else if (event.getComponentId().equals("testplugin_button4")) {
            event.reply("You clicked on a success button!").queue();
        }
    }
}

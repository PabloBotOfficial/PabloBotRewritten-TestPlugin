package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.Button;

import java.util.List;

public class TestButtonCommand implements DiscordCommandExecutor {

    @Override
    public boolean onCommand(Member member, User user, MessageChannel channel, String s, String[] args) {
        channel.sendMessage("Click the buttons below to test out the functionality!")
                .setActionRow(Button.primary("testplugin_button1", "Click Me!"),
                        Button.secondary("testplugin_button2", "Click Me!"),
                        Button.danger("testplugin_button3", "Click Me!"),
                        Button.success("testplugin_button4", "Click Me!"),
                        Button.link("https://discord.com/", "Click Me!")).queue();
        return false;
    }

    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String s, List<OptionMapping> list) {
        hook.sendMessage("Click the buttons below to test out the functionality!")
                .addActionRow(Button.primary("testplugin_button1", "Click Me!"),
                        Button.secondary("testplugin_button2", "Click Me!"),
                        Button.danger("testplugin_button3", "Click Me!"),
                        Button.success("testplugin_button4", "Click Me!"),
                        Button.link("https://discord.com/", "Click Me!")).queue();
        return false;
    }

}
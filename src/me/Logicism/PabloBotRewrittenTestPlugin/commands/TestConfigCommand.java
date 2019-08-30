package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.ConsoleCommandExecutor;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import me.Logicism.PabloBotRewrittenTestPlugin.TestPlugin;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jline.terminal.Terminal;

public class TestConfigCommand implements ConsoleCommandExecutor, DiscordCommandExecutor {
    @Override
    public boolean onCommand(Terminal terminal, String s, String[] args) {
        TestPlugin.plugin.getLogger().info(TestPlugin.config.getString("test1"));
        return false;
    }

    @Override
    public boolean onCommand(Member member, User user, MessageChannel channel, String s, String[] args) {
        channel.sendMessage(TestPlugin.config.getString("test1")).queue();
        return false;
    }
}

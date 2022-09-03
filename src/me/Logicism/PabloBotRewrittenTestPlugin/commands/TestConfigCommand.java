package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.ConsoleCommandExecutor;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import me.Logicism.PabloBotRewrittenTestPlugin.TestPlugin;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jline.terminal.Terminal;

import java.util.List;

public class TestConfigCommand implements ConsoleCommandExecutor, DiscordCommandExecutor {
    @Override
    public boolean onCommand(Terminal terminal, String s, String[] args) {
        TestPlugin.plugin.getLogger().info(TestPlugin.config.getString("test1"));
        for (String s1 : TestPlugin.config.getKeys()) {
            TestPlugin.plugin.getLogger().info(s1);
        }
        return false;
    }

    //Deprecated
    @Deprecated
    @Override
    public boolean onCommand(Member member, User user, MessageChannel channel, String s, String[] args) {
        channel.sendMessage("Prefix Commands are now Deprecated! Please use /testconfig").queue();
        return false;
    }

    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> list) {
        hook.sendMessage(TestPlugin.config.getString("test1")).queue();
        return false;
    }
}

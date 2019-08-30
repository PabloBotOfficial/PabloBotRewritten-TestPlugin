package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.PabloBotRewritten;
import me.Logicism.PabloBotRewritten.api.command.ConsoleCommandExecutor;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.jline.terminal.Terminal;

public class TestErrorCommand implements DiscordCommandExecutor, ConsoleCommandExecutor {
    @Override
    public boolean onCommand(Member member, User user, MessageChannel channel, String s, String[] args) {
        // Throws NullPointerException
        System.out.println(PabloBotRewritten.getInstance().getJDA().getGuildById(999).getName());
        return false;
    }

    @Override
    public boolean onCommand(Terminal terminal, String s, String[] args) {
        // Throws NullPointerException
        System.out.println(PabloBotRewritten.getInstance().getJDA().getGuildById(999).getName());
        return false;
    }
}

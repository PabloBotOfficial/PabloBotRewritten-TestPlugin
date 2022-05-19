package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class TestSubCommandsCommand implements DiscordCommandExecutor {
    @Override
    public boolean onCommand(Member member, User user, MessageChannel channel, String s, String[] strings) {
        channel.sendMessage("You can try out slash commands subcommands, use /testsubcommands").queue();
        return false;
    }

    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> list) {
        if (subcmd.equals("subcmd")) {
            hook.sendMessage("This is the first subcommand!").queue();
        } else if (subcmd.equals("subcmd1")) {
            hook.sendMessage("This is the second subcommand!").queue();
        } else if (subcmd.equals("subcmd2")) {
            hook.sendMessage("This is the third subcommand with the option:" + list.get(0).getAsString() + " !").queue();
        }
        return false;
    }
}

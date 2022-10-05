package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class TestEphemeralCommand implements DiscordCommandExecutor {

    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> list) {
        hook.setEphemeral(true).sendMessage("This is an Ephemeral Message! Only you can see this!").queue();
        return false;
    }

}

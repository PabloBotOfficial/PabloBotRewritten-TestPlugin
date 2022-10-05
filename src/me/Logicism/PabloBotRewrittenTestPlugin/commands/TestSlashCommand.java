package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class TestSlashCommand implements DiscordCommandExecutor {
    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> list) {
        if (list.size() == 1) {
            hook.sendMessage("Sent Arguments - required: " + list.get(0).getAsString()).queue();
        } else if (list.size() == 2) {
            hook.sendMessage("Sent Arguments - required: " + list.get(0).getAsString() + " optional: " + list.get(1).getAsString()).queue();
        }
        return false;
    }
}

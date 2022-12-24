package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;

import java.util.List;

public class TestEntitySelectMenuCommand implements DiscordCommandExecutor {
    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> args) {
        EntitySelectMenu.Builder builder = EntitySelectMenu.create("testplugin_selectionmenu", EntitySelectMenu.SelectTarget.CHANNEL);
        builder.setPlaceholder("Click on the menu to test the selection menu");
        builder.setChannelTypes(ChannelType.TEXT);
        builder.setRequiredRange(1, 1);
        hook.sendMessage("Click on the menu to test the selection menu").addActionRow(builder.build()).queue();
        return false;
    }
}

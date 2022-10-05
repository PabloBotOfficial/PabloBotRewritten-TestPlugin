package me.Logicism.PabloBotRewrittenTestPlugin.commands;

import me.Logicism.PabloBotRewritten.api.command.DiscordCommandExecutor;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.util.List;

public class TestSelectMenuCommand implements DiscordCommandExecutor {
    @Override
    public boolean onCommand(Member member, User user, InteractionHook hook, String subcmd, String s, List<OptionMapping> args) {
        SelectMenu.Builder builder = SelectMenu.create("testplugin_selectionmenu");
        builder.setPlaceholder("Click on the menu to test the selection menu");
        builder.addOption("Test Selection 1", "testselection1");
        builder.addOption("Test Selection 2", "testselection2");
        builder.addOption("Test Selection 3", "testselection3");
        builder.setRequiredRange(1, 1);
        hook.sendMessage("Click on the menu to test the selection menu").addActionRow(builder.build()).queue();
        return false;
    }
}

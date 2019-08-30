package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.api.plugin.PluginHelpMenu;
import me.Logicism.PabloBotRewritten.utils.GuildUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

public class TestPluginHelpMenu extends PluginHelpMenu {

    @Override
    public void executeHelpMenu(Member member, MessageChannel channel) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test PabloBot's Functionality", GuildUtils.getGuildPrefix(((TextChannel) channel).getGuild().getId()) + "testerror - Test the ErrorManager\n" + GuildUtils.getGuildPrefix(((TextChannel) channel).getGuild().getId()) + "testconfig - Test the Configuration", true);
        eb.setFooter("Custom Help Menu Test");
        channel.sendMessage(eb.build()).queue();
    }
}

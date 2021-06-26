package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.api.plugin.PluginHelpMenu;
import me.Logicism.PabloBotRewritten.utils.GuildUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class TestPluginHelpMenu extends PluginHelpMenu {

    @Override
    public void executeHelpMenu(Member member, MessageChannel channel) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test PabloBot's Functionality", GuildUtils.getGuildPrefix(((TextChannel) channel).getGuild().getId()) + "testerror - Test the ErrorManager\n" + GuildUtils.getGuildPrefix(((TextChannel) channel).getGuild().getId()) + "testconfig - Test the Configuration", true);
        eb.setFooter("Custom Help Menu Test");
        channel.sendMessage(eb.build()).queue();
    }

    @Override
    public void executeHelpMenu(Member member, InteractionHook hook) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test PabloBot's Functionality", "/testerror - Test the ErrorManager\n" + "/testconfig - Test the Configuration", true);
        eb.setFooter("Custom Help Menu Test");
        hook.sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public void executeHelpMenu(Member member, ButtonClickEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test PabloBot's Functionality", "/testerror - Test the ErrorManager\n" + "/testconfig - Test the Configuration", true);
        eb.setFooter("Custom Help Menu Test");
        e.editMessageEmbeds(eb.build()).queue();
    }
}

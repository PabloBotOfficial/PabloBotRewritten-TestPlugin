package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.api.plugin.PluginHelpMenu;
import me.Logicism.PabloBotRewritten.utils.GuildUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;

public class TestPluginHelpMenu extends PluginHelpMenu {

    @Override
    public void executeHelpMenu(Member member, MessageChannel channel) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.setDescription("Pablo!'s Prefix Commands are now deprecated! Please use Slash Commands to execute commands!");
        eb.addField("Commands to Test Pablo!'s Functionality", "/testbutton - Test the Buttons Functionality\n" + "/testconfig - Test the Configuration" + "/testephemeral - Test the Ephemeral Message Functionality\n" + "/testerror - Test the ErrorManager\n" + "/testmultiselectmenu - Test the Multi Select Menu Functionality\n" + "/testselectmenu - Test the Select Menu Functionality\n" + "/testslash - Test the Slash Commands Functionality\n" + "/testsubcommands - Test the SubCommands Functionality\n", true);
        eb.setFooter("Custom Help Menu Test");
        channel.sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public void executeHelpMenu(Member member, InteractionHook hook) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test Pablo!'s Functionality", "/testbutton - Test the Buttons Functionality\n" + "/testconfig - Test the Configuration" + "/testephemeral - Test the Ephemeral Message Functionality\n" + "/testerror - Test the ErrorManager\n" + "/testmultiselectmenu - Test the Multi Select Menu Functionality\n" + "/testselectmenu - Test the Select Menu Functionality\n" + "/testslash - Test the Slash Commands Functionality\n" + "/testsubcommands - Test the SubCommands Functionality\n", true);
        eb.setFooter("Custom Help Menu Test");
        hook.sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public void executeHelpMenu(Member member, SelectMenuInteractionEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("TestPlugin Help Menu");
        eb.addField("Commands to Test Pablo!'s Functionality", "/testbutton - Test the Buttons Functionality\n" + "/testconfig - Test the Configuration" + "/testephemeral - Test the Ephemeral Message Functionality\n" + "/testerror - Test the ErrorManager\n" + "/testmultiselectmenu - Test the Multi Select Menu Functionality\n" + "/testselectmenu - Test the Select Menu Functionality\n" + "/testslash - Test the Slash Commands Functionality\n" + "/testsubcommands - Test the SubCommands Functionality\n", true);
        eb.setFooter("Custom Help Menu Test");
        e.editMessageEmbeds(eb.build()).queue();
    }
}

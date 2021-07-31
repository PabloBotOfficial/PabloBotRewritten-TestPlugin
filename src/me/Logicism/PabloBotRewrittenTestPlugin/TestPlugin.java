package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.PabloBotRewritten;
import me.Logicism.PabloBotRewritten.api.command.ConsoleCommand;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommand;
import me.Logicism.PabloBotRewritten.api.configuration.FileConfiguration;
import me.Logicism.PabloBotRewritten.api.plugin.Plugin;
import me.Logicism.PabloBotRewrittenTestPlugin.commands.*;
import me.Logicism.PabloBotRewrittenTestPlugin.events.InteractionsEvents;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class TestPlugin extends Plugin {

    public static Plugin plugin;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        plugin = this;
        config = getConfig();

        getLogger().warn("This is not an actual warning! This is only a test!");

        config.addDefault("test1", "value1");
        config.addDefault("test2.testA", "value2");
        config.addDefault("test2.testB", "value3");
        config.options().copyDefaults(true);

        saveConfig();

        setHelpMenu(new TestPluginHelpMenu());

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testerror", "Test the ErrorManager", null, plugin), new TestErrorCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerConsoleCommand(new ConsoleCommand("testerror", "Test the ErrorManager", plugin), new TestErrorCommand());

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testconfig", "Test the plugin config", null, plugin), new TestConfigCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerConsoleCommand(new ConsoleCommand("testconfig", "Test the plugin config", plugin), new TestConfigCommand());

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testbutton", "Test out the buttons", null, plugin), new TestButtonCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testslash", "Test out slash commands", List.of(new OptionData(OptionType.STRING, "required", "The required subcommand").setRequired(true), new OptionData(OptionType.STRING, "optional", "The optional subcommand")), plugin), new TestSlashCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testephemeral", "Test out Ephemeral Messages", null, true, plugin), new TestEphemeralCommand());

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testselectionmenu", "Test out the selection menu", null, plugin), new TestSelectionMenuCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testmultiselectionmenu", "Test out the selection menu", null, plugin), new TestMultiSelectionMenuCommand());

        PabloBotRewritten.getInstance().getJDA().addEventListener(new InteractionsEvents());
    }

    @Override
    public void onDisable() {
        plugin = null;
        config = null;
    }
}

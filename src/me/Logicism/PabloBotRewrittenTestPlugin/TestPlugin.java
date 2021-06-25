package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.PabloBotRewritten;
import me.Logicism.PabloBotRewritten.api.command.ConsoleCommand;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommand;
import me.Logicism.PabloBotRewritten.api.configuration.FileConfiguration;
import me.Logicism.PabloBotRewritten.api.plugin.Plugin;
import me.Logicism.PabloBotRewrittenTestPlugin.commands.*;
import me.Logicism.PabloBotRewrittenTestPlugin.events.ButtonEvent;

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
        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testslash", "Test out slash commands", null, plugin), new TestSlashCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testephemeral", "Test out Ephemeral Messages", null, plugin), new TestEphemeralCommand());

        PabloBotRewritten.getInstance().getJDA().addEventListener(new ButtonEvent());
    }

    @Override
    public void onDisable() {
        plugin = null;
        config = null;
    }
}

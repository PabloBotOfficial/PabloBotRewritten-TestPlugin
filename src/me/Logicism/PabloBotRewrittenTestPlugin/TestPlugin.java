package me.Logicism.PabloBotRewrittenTestPlugin;

import me.Logicism.PabloBotRewritten.PabloBotRewritten;
import me.Logicism.PabloBotRewritten.api.command.ConsoleCommand;
import me.Logicism.PabloBotRewritten.api.command.DiscordCommand;
import me.Logicism.PabloBotRewritten.api.configuration.FileConfiguration;
import me.Logicism.PabloBotRewritten.api.plugin.Plugin;
import me.Logicism.PabloBotRewrittenTestPlugin.commands.TestConfigCommand;
import me.Logicism.PabloBotRewrittenTestPlugin.commands.TestErrorCommand;

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

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testerror", "Test the ErrorManager", plugin), new TestErrorCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerConsoleCommand(new ConsoleCommand("testerror", "Test the ErrorManager", plugin), new TestErrorCommand());

        PabloBotRewritten.getInstance().getCommandManager().registerDiscordCommand(new DiscordCommand("testconfig", "Test the plugin config", plugin), new TestConfigCommand());
        PabloBotRewritten.getInstance().getCommandManager().registerConsoleCommand(new ConsoleCommand("testconfig", "Test the plugin config", plugin), new TestConfigCommand());
    }

    @Override
    public void onDisable() {
        plugin = null;
        config = null;
    }
}

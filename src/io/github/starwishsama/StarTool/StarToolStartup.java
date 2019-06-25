package io.github.starwishsama.StarTool;

import io.github.starwishsama.StarTool.Commands.*;
import io.github.starwishsama.StarTool.Config.Config;
import io.github.starwishsama.StarTool.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import io.github.starwishsama.StarTool.CheckUpdate.UpdateChecker;

import java.io.File;

public class StarToolStartup extends JavaPlugin {
    private static StarToolStartup instance;

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists())
            config.mkdirs();

        Config.loadConfig();

        Bukkit.getPluginManager().registerEvents(new LevelChatPrefix(), this);
        Bukkit.getPluginManager().registerEvents(new LevelUpTips(), this);
        Bukkit.getPluginManager().registerEvents(new ChatSendMyPos(), this);
        Bukkit.getPluginManager().registerEvents(new AutoWelcome(), this);
        Bukkit.getPluginManager().registerEvents(new CommandHandler(), this);

        Bukkit.getPluginCommand("curse").setExecutor(new CurseCommand());
        Bukkit.getPluginCommand("startool").setExecutor(new StarToolCommand());
        Bukkit.getPluginCommand("gc").setExecutor(new GcCommand());
        Bukkit.getPluginCommand("tp").setExecutor(new TeleportCommand());
        Bukkit.getPluginCommand("tphere").setExecutor(new TeleportCommand());
        Bukkit.getPluginCommand("tpa").setExecutor(new TeleportCommand());
        Bukkit.getPluginCommand("tpaccept").setExecutor(new TeleportCommand());
        Bukkit.getPluginCommand("tpdeny").setExecutor(new TeleportCommand());
        Bukkit.getPluginCommand("home").setExecutor(new HomeCommand());
        Bukkit.getPluginCommand("gm").setExecutor(new GameModeCommand());
        Bukkit.getPluginCommand("enderchest").setExecutor(new PortableEnderChestCommand());
        Bukkit.getPluginCommand("msg").setExecutor(new PrivateMsgCommand());

        getLogger().info("正在检查服务器是否安装 Vault 以启用小喇叭..");
        if (Bukkit.getPluginManager().getPlugin("Vault") == null){
            getLogger().warning("未发现服务器安装了 Vault, 将自动禁用小喇叭指令!");
        } else {
            Bukkit.getPluginCommand("laba").setExecutor(new LabaCommand());
            getLogger().info("已发现 Vault 插件!");
        }

        getLogger().info("欢迎使用 StarTool, 版本 " + getDescription().getVersion());
        UpdateChecker.CheckUpdate();
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        getLogger().info("正在关闭插件...");
        saveDefaultConfig();
    }

    public static StarToolStartup getInstance() {
        return instance;
    }
}

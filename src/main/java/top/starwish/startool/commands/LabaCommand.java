package top.starwish.startool.Commands;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.starwish.startool.Files.Config;
import top.starwish.startool.PluginHook.VaultLib;

public class LabaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("laba")) {
            if (sender instanceof Player) {
                if (!Config.getEnableLaba) {
                    if (sender.hasPermission("startool.laba.use")) {
                        if (args.length == 0) {
                            sender.sendMessage("§bStarTool > §e使用方法: /laba <内容>");
                            return true;
                        }
                        if (args.length == 1) {
                            if (!sender.hasPermission("startool.laba.bypass")) {
                                EconomyResponse s = VaultLib.getEconomy().bankWithdraw(sender.getName(), Config.getLabaPrice);
                                if (s.transactionSuccess()) {
                                    sender.sendMessage("§b你已成功发送了一条小喇叭!");
                                    Bukkit.broadcastMessage("§d§l" + sender.getName() + " §e§l说: " + args[0]);
                                    return true;
                                } else {
                                    sender.sendMessage("§b StarTool §c> 你没有足够的金钱!");
                                }
                            }
                            else {
                                sender.sendMessage("§b由于你与服主完成了某种交易, 本次发送无需费用!");
                                Bukkit.broadcastMessage("§d§l" + sender.getName() + " §e§l说: " + args[0]);
                                return true;
                            }
                        }
                    } else sender.sendMessage("§bStarTool §c> 你没有权限!");
                } else sender.sendMessage("§bStarTool > §c服务器未启用小喇叭!");
            }
        }
        return false;
    }
}

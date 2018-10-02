package top.starwish.startool.commands;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.starwish.startool.econemy.VaultLib;
import top.starwish.startool.config.configsetup;

public class LabaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("laba")) {
            if (sender instanceof Player) {
                if (!Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled() && !configsetup.EnableLaba) {
                    sender.sendMessage("��bStarTool > ��c������δ��װ���ò��/��δ����С����!");
                    if (sender.hasPermission("startool.laba.use")) {
                        if (args.length == 0) {
                            sender.sendMessage("��bStarTool > ��eʹ�÷���: /laba <����>");
                            return true;
                        }
                        if (args.length == 1) {
                            if (!sender.hasPermission("startool.laba.bypass")) {
                                EconomyResponse s = VaultLib.getEconomy().bankWithdraw(sender.getName(), configsetup.LabaPrice);
                                if (s.transactionSuccess()) {
                                    sender.sendMessage("��b���ѳɹ�������һ��С����!");
                                    Bukkit.broadcastMessage("��d��l" + sender.getName() + " ��e��l˵: " + args[0]);
                                    return true;
                                } else {
                                    sender.sendMessage("��b StarTool ��c> ��û���㹻�Ľ�Ǯ!");
                                }
                            }
                            else {
                                sender.sendMessage("��b����������������ĳ�ֽ���, ���η����������!");
                                Bukkit.broadcastMessage("��d��l" + sender.getName() + " ��e��l˵: " + args[0]);
                                return true;
                            }
                        }
                    } else {
                        sender.sendMessage("��bStarTool ��c> ��û��Ȩ��!");
                    }
                }
            }
        }
        return false;
    }
}

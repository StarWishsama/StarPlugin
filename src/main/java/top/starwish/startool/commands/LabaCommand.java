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
                if (!Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled()) {
                    sender.sendMessage("��bStarTool > ��c������δ��װ���ò��, С�����ѱ�����!");
                    if (sender.hasPermission("startool.laba")) {
                        if (args.length == 0) {
                            sender.sendMessage("��bStarTool > ��eʹ�÷���: /laba <����>");
                            return true;
                        }
                        if (args.length == 1) {
                            EconomyResponse s = VaultLib.getEconomy().bankWithdraw(sender.getName(), configsetup.LabaPrice);
                            if (s.transactionSuccess()) {
                                Bukkit.broadcastMessage("��b��� ��e" + sender.getName() + " ��b������һ��С������Ϣ!");
                                Bukkit.broadcastMessage("��d��l" + sender.getName() + " ��e��l˵: " + args[0]);
                                return true;
                            } else {
                                sender.sendMessage("��b StarTool ��c> ��û���㹻�Ľ�Ǯ!");
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

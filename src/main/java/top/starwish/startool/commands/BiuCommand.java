package top.starwish.startool.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// WIP
public class BiuCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("biu")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("startool.biu")) {
                    if (args.length == 0) {
                        player.setHealth(0);
                        sender.sendMessage("Testing...");
                        sender.sendMessage("��bStarTool > ��e�㱻������Biu��һ��!��ϲ��!");
                    }
                    if (args.length == 1) {
                        if (sender.hasPermission("starwish.biu.other")) {
                            Player otherp = (Player) Bukkit.getPlayer("args[0]");
                            if (otherp == null) {
                                sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                            }
                            otherp.setHealth(0);
                            otherp.sendMessage("��bStarTool > ��e�㱻������ ��c" + sender.getName() + " ��eBiu��һ��!��ϲ��!");
                            sender.sendMessage("��bStarTool > ��e�ɹ���ɱ��� " + otherp.getName() + " ��e!");
                            return true;
                        } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                    } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
            } else sender.sendMessage("��bStarTool > ��c��û��Ȩ��!");
        } else sender.sendMessage("��bStarTool > ��c���������Ϸ��ʹ�ø�����!");
        return false;
    }
}



package top.starwish.startool.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurseCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("curse")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("startool.curse.use")) {
                    if (args.length == 0) {
                        player.setHealth(0);
                        sender.sendMessage("�� �� �� �� �� ��");
                    }
                    if (args.length == 1) {
                        if (sender.hasPermission("startool.curse.other")) {
                            Player otherp = Bukkit.getPlayer("args[0]");
                            if (otherp == null) {
                                sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                            }
                            if (otherp == null && otherp.hasPermission("startool.curse.anticurse")){
                                sender.sendMessage("��bStarTool > ��c������Ҳ�����/������/�޷�����!");
                            }
                            else {
                                otherp.setHealth(0);
                                otherp.sendMessage("��bStarTool > ��e�㱻ĳ����Ҽ�������!");
                                sender.sendMessage("��bStarTool > ��e�ɹ������� " + otherp.getName() + " !");
                                return true;
                            }
                        } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                    } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
                } else sender.sendMessage("��bStarTool > ��c������Ҳ�����/������!");
            } else sender.sendMessage("��bStarTool > ��c��û��Ȩ��!");
        } else sender.sendMessage("��bStarTool > ��c���������Ϸ��ʹ�ø�����!");
        return false;
    }
}



package top.starwish.startool.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * δʹ��
 */

public class BiuCommand
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("biu"))
        {

            if (!(sender instanceof Player))
            {
                    sender.sendMessage("��bStarTool > ��e���������Ϸ��ʹ�ø�����!");
            }

            else if  (!sender.hasPermission("startool.biu")) sender.sendMessage("��bStarTool > ��c��û��Ȩ����ִ����������!");
            
            else {
                Player player = (Player) sender;

                player.setHealth(0);
                sender.sendMessage("��bStarTool > ��e�㱻������Biu��һ��!��ϲ��!");
                return true;

            }
        }
        return false;
    }
}

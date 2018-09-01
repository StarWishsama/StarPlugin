package top.starwish.startool.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LabaCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("laba"))
        {
            if (sender.hasPermission("startool.laba"))
            {
                //Player player = (Player) sender;
                if (args.length == 0)
                {
                        sender.sendMessage("��bStarTool > ��eʹ�÷���: /laba <����>");
                        return true;
                }

                if (args.length == 1)
                {
                    //EconomyResponse s = econ.bankWithdraw(sender.getName(), 50);
                    //if (s.transactionSuccess()) {
                        Bukkit.broadcastMessage("��b��� ��e" + sender.getName() + " ��b������һ��С������Ϣ!");
                        Bukkit.broadcastMessage("��d��l" + sender.getName() + " ��e��l˵: " + args[0]);
                        return true;
                }
            }

            else
            {
                sender.sendMessage("��bStarTool > ��c��û��Ȩ��!");
            }
        }
        return false;
    }
}

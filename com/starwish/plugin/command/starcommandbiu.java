package com.starwish.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ָ�� Biu�������.
 * ̫����������Ū����д XD
 */

public class starcommandbiu implements CommandExecutor
{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if (cmd.getName().equalsIgnoreCase("biu"))
	    {
		    if (!(sender instanceof Player)) 
		    {
		    sender.sendMessage("��bStarPlugin > ��e���������Ϸ��ʹ�ø�����!");
		    return true;
		    }
		    
		    Player player = (Player) sender;
	    	  		
	    	player.setHealth(0);
	    	sender.sendMessage("��bStarPlugin > ��e�㱻������Biu��һ��!��ϲ��!");
	    	return true;
	    }
		return false;		
	}
}
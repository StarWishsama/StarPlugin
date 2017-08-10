package com.starwish.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class starcommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if (cmd.getName().equalsIgnoreCase("starplugin"))
		{	
		    if (args.length == 0 || sender instanceof ConsoleCommandSender)
		    {
			sender.sendMessage("��bStarPlugin V0.0.8 Dev, By StarWish_");
			sender.sendMessage("��f");
			sender.sendMessage("/biu [���] ��һ���������ȥ��");
			sender.sendMessage("/starp uuid ��ȡĳλ��ҵ�UUID");
			sender.sendMessage("/starp clear ����������");
			sender.sendMessage("/starp version ��ʾ���Ŀǰ�汾��");
			sender.sendMessage("/sptest Debug ����");
			sender.sendMessage("��f");
			sender.sendMessage("��c��l��ע�⡣�������֧��/reload����!");
			return true;
		    }
		    
		    if (args[0].equalsIgnoreCase("uuid")){
		    	
		    	Player p = (Player) sender;
		    	
		    	if (sender.hasPermission("starplugin.uuid"))
		    	{
			    	
			    		sender.sendMessage("��bStarPlugin > ��c���ڻ�ȡ����UUID...");
				    	sender.sendMessage("��bStarPlugin > ��e���UUIDΪ:" + p.getUniqueId());	
				    	return true;
			    }
		    	else 
		    	{
		    		sender.sendMessage("��bStarPlugin > ��c��û��Ȩ����ִ����������!");
		    		return true;
		    	}	    	
		    }
		    
		    if (args[0].equalsIgnoreCase("version"))
		    {
		    	if (sender.hasPermission("starplugin.version") || sender instanceof ConsoleCommandSender)
		    	{
					sender.sendMessage("��bStarPlugin > ��eĿǰ�汾Ϊ: ��aV0.0.8 DEV");					
		    	}
		    	else 
		    	{
		    		sender.sendMessage("��bStarPlugin > ��c��û��Ȩ����ִ����������!");
		    	}
		      return true;	
		   }
		    
		   if (args[0].equalsIgnoreCase("updatelog") || sender instanceof ConsoleCommandSender)
		   {
			   sender.sendMessage("��bV0.0.8 DEV ������־:");
			   sender.sendMessage("�޸� Bug");
			   sender.sendMessage("��/biu��������෽��δ�� Coding.");
			   sender.sendMessage("�޸�����Bug.");
		   }
		    
		   if (args[0].equalsIgnoreCase("clear"))
		   {
			    if (!(sender instanceof Player)) 
			    {
			    sender.sendMessage("��bStarPlugin > ��e���������Ϸ��ʹ�ø�����!");
			    return true;
			    }
			    
			    if (sender.hasPermission("starplugin.clearscreen"))
					   {
				         sender.sendMessage("��bStarPlugin > ��c��û��Ȩ����ִ����������!");
					   } 
				         for(int i = 0; i <= 50; i++)
				         sender.sendMessage(" ");
				         sender.sendMessage("��bStarPlugin > ��e�����ɹ�~"); 
				         return true;
		   }
	   }
        return false;
    }
}	
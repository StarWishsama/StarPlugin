package top.starwish.startool.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LevelChatPrefix implements Listener
{
    @EventHandler
    public void ChatLevel(AsyncPlayerChatEvent event)
    {
        //if () {
        event.setFormat("��f[��e" + event.getPlayer().getLevel() + "��e����f]" + event.getFormat());
    }
}

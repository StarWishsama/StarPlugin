package top.starwish.startool.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelUpTips implements Listener
{
    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent event)
    {
        Player player = event.getPlayer();
        if (event.getNewLevel() < event.getOldLevel())
        {
            return;
        }
        player.sendTitle("��e��lҮ! ��ϲ��������!", "��a��ǰ�ȼ�Ϊ: " + event.getNewLevel(), 50, 80, 50);
        player.sendMessage("��bStarTool > ��e" + event.getPlayer().getName() + "��e,��ϲ�������� " + event.getNewLevel() + "��e��!");
        return;
    }
}

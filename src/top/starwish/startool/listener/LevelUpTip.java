package top.starwish.startool.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelUpTip implements Listener
{
	public void LevelChange(PlayerLevelChangeEvent event)
    {
        Player a = (Player) event.getPlayer();

        if (event.getNewLevel() < event.getOldLevel())
        {
            return;
        }
        
        a.sendTitle("��e��lҮ! ��ϲ��������!", "��a��ǰ�ȼ�Ϊ: " + event.getNewLevel(), 10, 70, 20);
        return;
    }
}
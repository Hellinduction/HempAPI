package cyou.hotbox.api.managers;

import cyou.hotbox.api.command.BaseCommand;
import org.bukkit.entity.Player;

import java.util.List;

public interface PlayerManagerBase {
    boolean isAuthed(final String name);
    boolean isVanished(final String name);
    boolean isToggled(final String commandStr, final String name);
    BaseCommand getCommand(final String commandStr);
    List<Player> getToggledOn(final String commandStr);
}
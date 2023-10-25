package cyou.hotbox.api.sender;

import org.bukkit.entity.Player;

public interface HSender {
    void sendMessage(final String message);
    void sendMessage(final String message, final boolean prefix);
    boolean isPlayer();
    String getName();
    Player getPlayer() throws UnsupportedOperationException;
    boolean isAuthed();
    boolean isVanished();
}
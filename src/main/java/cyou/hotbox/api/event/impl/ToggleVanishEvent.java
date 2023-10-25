package cyou.hotbox.api.event.impl;

import cyou.hotbox.api.event.HEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.List;

@Getter
@AllArgsConstructor
public final class ToggleVanishEvent extends HEvent {
    private final List<Player> targets;
    private final boolean value;
}
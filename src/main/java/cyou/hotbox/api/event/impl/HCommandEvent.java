package cyou.hotbox.api.event.impl;

import cyou.hotbox.api.event.HEvent;
import cyou.hotbox.api.sender.HSender;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;

@Getter
@Setter
public final class HCommandEvent extends HEvent implements Cancellable {
    private boolean cancelled;

    private String command;
    private String[] args;
    private HSender sender;

    public HCommandEvent(final String command, final String[] args, final HSender sender) {
        this.command = command;
        this.args = args;
        this.sender = sender;
    }
}
package cyou.hotbox.api.event.impl;

import cyou.hotbox.api.event.HEvent;
import cyou.hotbox.api.theme.Theme;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;

@Getter
@Setter
public final class ThemeChangeEvent extends HEvent implements Cancellable {
    private boolean cancelled;

    private final Theme currentTheme;
    private Theme newTheme;

    public ThemeChangeEvent(final Theme currentTheme, final Theme newTheme) {
        this.currentTheme = currentTheme;
        this.newTheme = newTheme;
    }
}
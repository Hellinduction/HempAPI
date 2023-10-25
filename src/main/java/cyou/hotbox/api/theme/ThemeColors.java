package cyou.hotbox.api.theme;

import cyou.hotbox.api.HempAPI;
import cyou.hotbox.api.event.impl.ThemeChangeEvent;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.event.EventPriority;

import java.util.Arrays;
import java.util.List;

@Getter
public enum ThemeColors {
    SUCCESS('s'),
    FAILURE('f'),
    CAUTION('c'),
    NORMAL('n'),
    HIGHLIGHTED('h');

    private final char code;
    private ChatColor color;
    private String toString;

    ThemeColors(final char code) {
        this.code = code;
    }

    public ChatColor getColor() {
        if (this.color != null)
            return this.color;

        return this.color = get(this);
    }

    @Override
    public String toString() {
        if (this.toString != null)
            return this.toString;

        this.getColor();
        return this.toString = this.getString();
    }

    public void update(final Theme theme) {
        this.color = get(this, theme);
        this.toString = this.getString();
    }

    private String getString() {
        return new String(new char[] { ChatColor.COLOR_CHAR, this.color.getChar() });
    }

    /**
     * Translates the colors in string to actual minecraft colors
     * @param colorChar
     * @param text
     * @return
     */
    public static String translateColors(final char colorChar, String text) {
        final List<ThemeColors> colors = Arrays.asList(ThemeColors.values());

        for (final ThemeColors color : colors)
            text = text.replace(colorChar + String.valueOf(color.getCode()), ChatColor.COLOR_CHAR + String.valueOf(color.getColor().getChar()));

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Translates the colors in string to actual minecraft colors
     * Uses '$' as colorChar
     * @param text
     * @return
     */
    public static String translateColors(final String text) {
        return translateColors('$', text);
    }

    /**
     * Effectively highlights the args
     * THANKS FLUYD!!!
     * @param text
     * @param args
     * @return
     */
    public static String format(final String text, ThemeColors color, final String... args) {
        final String[] splits = text.split("%s");
        final StringBuilder builder = new StringBuilder();

        final int length = splits.length;

        for (int i = 0; i < length; ++i) {
            if (i == 0) {
                builder.append(color).append(splits[i]);
                continue;
            }

            builder.append(ThemeColors.HIGHLIGHTED).append(args[i - 1]).append(color).append(splits[i]);
        }

        if (args.length == length)
            builder.append(ThemeColors.HIGHLIGHTED).append(args[args.length -1]).append(color);

        return builder.toString();
    }

    public static ChatColor get(final ThemeColors color) {
        return ThemeColors.get(color, HempAPI.theme);
    }

    public static ChatColor get(final ThemeColors color, final Theme theme) {
        switch (color) {
            case SUCCESS:
                return theme.success();
            case FAILURE:
                return theme.failure();
            case CAUTION:
                return theme.caution();
            case NORMAL:
                return theme.normal();
            case HIGHLIGHTED:
                return theme.highlighted();
            default:
                return null;
        }
    }

    public static void updateAll(final Theme theme) {
        for (final ThemeColors color : ThemeColors.values())
            color.update(theme);
    }

    static {
        HempAPI.registerListener(EventPriority.MONITOR, ThemeChangeEvent.class, e -> updateAll(e.getNewTheme()));
    }
}
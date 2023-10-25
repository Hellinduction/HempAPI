package cyou.hotbox.api.theme;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bukkit.ChatColor;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public final class Theme {
    private String themeName;

    public Theme(final String themeName) {
        this.themeName = themeName;
    }

    /**
     * Success and failure
     */
    private ChatColor success;
    private ChatColor failure;

    /**
     * Errors
     */
    private ChatColor caution;

    /**
     * Text
     */
    private ChatColor normal;
    private ChatColor highlighted;

    /**
     * Prefix
     */
    private String name;
    private String prefix;

    /**
     * Parse color codes in string
     * @param str
     * @return
     */
    public static String colorize(final String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String strip(final String str) {
        return ChatColor.stripColor(colorize(str));
    }
}
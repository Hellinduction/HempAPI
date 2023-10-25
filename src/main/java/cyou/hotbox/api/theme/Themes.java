package cyou.hotbox.api.theme;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public final class Themes {
    public static final Map<String, Theme> THEMES = new HashMap<>();

    public static final Theme HEMP;
    public static final Theme QLUTCH;
    public static final Theme FREE_FLOW;
    public static final Theme BLURRY;
    public static final Theme BROMINE;

    static {
        HEMP = new Theme("HEMP").success(ChatColor.DARK_GREEN)
                .failure(ChatColor.DARK_RED)
                .caution(ChatColor.GOLD)
                .normal(ChatColor.GRAY)
                .highlighted(ChatColor.YELLOW)
                .name(Theme.colorize("&cHemp"));
        HEMP.prefix(String.format("%s[%s%s]", HEMP.normal(), HEMP.name(), HEMP.normal()));
        put(HEMP);

        QLUTCH = new Theme("QLUTCH").success(ChatColor.WHITE)
                .failure(ChatColor.WHITE)
                .caution(ChatColor.WHITE)
                .normal(ChatColor.DARK_RED)
                .highlighted(ChatColor.RED)
                .name("qlutch");
        QLUTCH.prefix(String.format("%s%s %sl%s", QLUTCH.normal(), QLUTCH.name(), ChatColor.DARK_GRAY, QLUTCH.success()));
        put(QLUTCH);

        FREE_FLOW = new Theme("FREEFLOW").success(ChatColor.GREEN)
                .failure(ChatColor.RED)
                .caution(ChatColor.RED)
                .normal(ChatColor.GRAY)
                .highlighted(ChatColor.YELLOW)
                .name("FreeFlow")
                .prefix("");
        put(FREE_FLOW);

        BLURRY = new Theme("BLURRY").success(ChatColor.GREEN)
                .failure(ChatColor.DARK_RED)
                .caution(ChatColor.RED)
                .normal(ChatColor.GOLD)
                .highlighted(ChatColor.DARK_PURPLE)
                .name("Blurry");
        BLURRY.prefix(String.format("%s(%s%s%s)", ChatColor.GRAY, ChatColor.LIGHT_PURPLE, BLURRY.name(), ChatColor.GRAY));
        put(BLURRY);

        BROMINE = new Theme("BROMINE").success(ChatColor.DARK_GREEN)
                .failure(ChatColor.DARK_RED)
                .caution(ChatColor.GOLD)
                .normal(ChatColor.GRAY)
                .highlighted(ChatColor.DARK_GREEN)
                .name("Bromine");
        BROMINE.prefix(Theme.colorize(String.format("&8(&c%s&8)", BROMINE.name())));
        put(BROMINE);
    }

    private static void put(final Theme theme) {
        THEMES.put(theme.themeName().toUpperCase(), theme);
    }
}
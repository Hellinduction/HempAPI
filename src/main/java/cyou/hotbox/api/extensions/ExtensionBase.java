package cyou.hotbox.api.extensions;

import org.bukkit.plugin.Plugin;

public interface ExtensionBase {
    String getId();
    String getName();
    String getAuthor();
    String getDescription();
    String getVersion();
    void onLoad(final Plugin plugin);
    void onUnload();
}
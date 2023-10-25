package cyou.hotbox.api;

import cyou.hotbox.api.command.BaseCommand;
import cyou.hotbox.api.event.HEvent;
import cyou.hotbox.api.event.HListener;
import cyou.hotbox.api.event.impl.ThemeChangeEvent;
import cyou.hotbox.api.extensions.impl.Extension;
import cyou.hotbox.api.managers.PlayerManagerBase;
import cyou.hotbox.api.theme.Theme;
import cyou.hotbox.api.theme.Themes;
import org.bukkit.event.EventPriority;

import java.util.*;
import java.util.function.Consumer;

public final class HempAPI {
    private static final Map<EventPriority, List<HListener>> LISTENERS = new HashMap<>();
    public static Consumer<Extension> onSetJson = null;
    public static Consumer<BaseCommand> onRegisterCommand = null;
    public static Theme theme = Themes.HEMP;
    public static PlayerManagerBase playerManager = null;

    /**
     * Register a listener
     * @param priority
     * @param callback
     */
    public static void registerListener(final EventPriority priority, final Consumer<HEvent> callback) {
        registerListener(priority, HEvent.class, callback);
    }

    /**
     * Register a listener
     * @param priority
     * @param eventClass
     * @param callback
     */
    public static <T> void registerListener(final EventPriority priority, final Class<? extends T> eventClass, final Consumer<T> callback) {
        List<HListener> listeners = new ArrayList<>();

        if (LISTENERS.containsKey(priority))
            listeners = LISTENERS.get(priority);

        final HListener listener = new HListener(callback, eventClass);
        listeners.add(listener);

        LISTENERS.put(priority, listeners);
    }

    /**
     * Call an event
     * @param e
     */
    public static void callEvent(final HEvent e) {
        final List<EventPriority> priorities = Arrays.asList(EventPriority.values());
        Collections.sort(priorities, Comparator.comparingInt(EventPriority::getSlot)); // Sorting list from lowest slot to highest slot

        for (final EventPriority priority : priorities) {
            if (!LISTENERS.containsKey(priority))
                continue;

            final List<HListener> listeners = LISTENERS.get(priority);
            for (final HListener listener : listeners) {
                final Class<?> eventClass = listener.getEventClass();

                if (!eventClass.isAssignableFrom(e.getClass()))
                    continue;

                listener.getCallback().accept(e);
            }
        }
    }

    public static void registerCommand(final BaseCommand command) {
        onRegisterCommand.accept(command);
    }

    /**
     * Use this to properly set the Theme
     * @param theme
     * @return
     */
    public static ThemeChangeEvent setTheme(final Theme theme) {
        final ThemeChangeEvent event = new ThemeChangeEvent(HempAPI.theme, theme);
        HempAPI.callEvent(event);

        if (event.isCancelled())
            return event;

        HempAPI.theme = theme;
        return event;
    }
}
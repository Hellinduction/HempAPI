package cyou.hotbox.api.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Consumer;

@AllArgsConstructor
@Getter
public final class HListener<T> {
    private final Consumer<T> callback;
    private final Class<? extends HEvent> eventClass;
}
package cyou.hotbox.api.event.impl;

import cyou.hotbox.api.event.HEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public final class GlobalBanReloadEvent extends HEvent {
    private final List<String> banned; // mutable
}
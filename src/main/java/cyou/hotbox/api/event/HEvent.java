package cyou.hotbox.api.event;

public abstract class HEvent {
    private final String name;

    public HEvent() {
        this.name = this.getClass().getSimpleName();
    }

    public final String getEventName() {
        return this.name;
    }
}
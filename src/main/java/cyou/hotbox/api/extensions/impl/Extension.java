package cyou.hotbox.api.extensions.impl;

import cyou.hotbox.api.HempAPI;
import cyou.hotbox.api.extensions.ExtensionBase;

public abstract class Extension implements ExtensionBase {
    private final String id = null;
    private final String name = null;
    private final String author = null;
    private final String description = null;
    private final String version = null;

    private String json = null; // Json string, gets saved, and set back when next loaded (Effectively a config)

    @Override
    public String getId() { return this.id; }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final String getAuthor() { return this.author; }

    @Override
    public final String getDescription() {
        return this.description;
    }

    @Override
    public final String getVersion() { return this.version; }

    public String getJson() {
        return this.json;
    }

    /**
     * Ensure tp set json before loading the extension
     * @param json
     */
    public final void setJson(final String json) {
        this.json = json;
        HempAPI.onSetJson.accept(this);
    }
}
package cyou.hotbox.api.command;

import cyou.hotbox.api.sender.HSender;
import lombok.Getter;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public abstract class BaseCommand {
    private final String name;
    private final String description;
    private final OperatingSystems allowedSystems;
    private final List<String> aliases;

    private final Settings settings = new Settings();

    protected BaseCommand(final String name, final String description, OperatingSystems allowedSystems, final String... aliases) {
        this.name = name;
        this.description = description;
        this.allowedSystems = allowedSystems;
        this.aliases = Arrays.asList(aliases).stream().map(alias -> alias.toLowerCase()).collect(Collectors.toList());
    }

    public abstract void run(final HSender sender, final String[] args) throws Throwable;

    /**
     * Converts this Command object to a json string
     * @return
     */
    public final JSONObject toJson() {
        final JSONObject obj = new JSONObject();

        obj.put("description", this.description);
        obj.put("aliases", this.aliases);
        obj.put("allowed_systems", this.allowedSystems);

        final String usage = this.settings.usage();
        if (usage != null)
            obj.put("usage", usage);

        obj.put("min_args", this.settings.minArgs());
        obj.put("min_console_args", this.settings.minConsoleArgs());
        obj.put("is_async", this.settings.async());
        obj.put("new_api_only", this.settings.newApiOnly());
        obj.put("old_api_only", this.settings.oldApiOnly());
        obj.put("admin_only", this.settings.adminOnly());
        obj.put("require_confirmation", this.settings.requireConfirmation());
        obj.put("ignore", this.settings.ignore());
        obj.put("hide", this.settings.hide());

        return obj;
    }
}
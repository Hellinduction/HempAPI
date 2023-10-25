package cyou.hotbox.api.command;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
public final class Settings {
    /**
     * Usage of command. Example: "<player> <reason>"
     * @return
     */
    private String usage = null;

    /**
     * Minimum amount of arguments needed to run command
     * @return
     */
    private int minArgs = 0;

    /**
     * Minimum amount of arguments for the console to run the command
     * Setting to -1 will disable command for the console
     * @return
     */
    private int minConsoleArgs = 0;

    /**
     * Does this command run asynchronously?
     * @return
     */
    private boolean async = false;

    /**
     * Does this command only allow newer versions
     * @return
     */
    private boolean newApiOnly = false;

    /**
     * Does this command only allow older versions
     * @return
     */
    private boolean oldApiOnly = false;

    /**
     * Can only be run if the owner of this server is admin in Hemp
     * @return
     */
    private boolean adminOnly = false;

    /**
     * This is for commands that are dangerous to execute and should require the player to type 'confirm' after the commands arguments
     * @return
     */
    private boolean requireConfirmation = false;

    /**
     * Will be ignored from CommandManager.lookupCommand() unless stated otherwise in method call
     * @return
     */
    private boolean ignore = false;

    /**
     * Should this command be hidden from the help command?
     * @return
     */
    private boolean hide = false;
}
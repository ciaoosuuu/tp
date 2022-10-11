package seedu.waddle.logic.commands;

import seedu.waddle.logic.StageManager;
import seedu.waddle.logic.Stages;
import seedu.waddle.logic.commands.exceptions.CommandException;
import seedu.waddle.model.Model;

/**
 * Changes the remark of an existing person in the address book.
 */
public class HomeCommand extends Command {

    public static final String COMMAND_WORD = "home";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": returns to the home page\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_HOME_SUCCESS = "Waddled back to the home page";

    public static final String MESSAGE_ALREADY_HOME_SUCCESS = "Already waddling in the home page";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        StageManager stageManager = StageManager.getInstance();

        // if already at home page, do nothing and tell user
        if (stageManager.isCurrentStage(Stages.HOME)) {
            return new CommandResult(MESSAGE_ALREADY_HOME_SUCCESS);
        }

        // change to home stage in stage manager
        stageManager.setHomeStage();

        return new CommandResult(MESSAGE_HOME_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        return other instanceof HomeCommand;

    }
}
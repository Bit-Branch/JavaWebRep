package by.epam.committiee.command;

import by.epam.committiee.command.impl.Logout;
import by.epam.committiee.command.impl.SignIn;
import by.epam.committiee.command.impl.SignUp;
import by.epam.committiee.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName,ActionCommand> repository = new HashMap<>();
    private static final CommandProvider instance = new CommandProvider();

    private CommandProvider(){
        repository.put(CommandName.SIGN_IN,new SignIn());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.LOGOUT, new Logout());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public static CommandProvider getInstance(){
        return instance;
    }

    public ActionCommand getCommand(String name) {
        CommandName commandName;
        ActionCommand command;
        try {
            if (name == null){
                throw new IllegalArgumentException();
            }
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
            if (command == null){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
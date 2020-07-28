package by.epam.committiee.command;

import by.epam.committiee.command.impl.*;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName,ActionCommand> repository = new HashMap<>();
    private static final CommandProvider instance = new CommandProvider();

    private CommandProvider(){
        repository.put(CommandName.SIGN_IN,new SignIn());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.LOGOUT, new Logout());
        repository.put(CommandName.SHOW_FACULTIES,new ShowFaculties());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.PROFILE, new Profile());
        repository.put(CommandName.CHOOSE_FACULTY, new ChooseFaculty());
        repository.put(CommandName.CHOOSE_SPECIALTY, new ChooseSpecialty());
        repository.put(CommandName.MY_MARKS, new MyMarks());
        repository.put(CommandName.MY_SPECIALTIES, new MySpecialties());
        repository.put(CommandName.EDIT_USERS, new EditUsers());
        repository.put(CommandName.EDIT_FACULTIES, new EditFaculties());
        repository.put(CommandName.EDIT_SPECIALTIES, new EditSpecialties());
        repository.put(CommandName.USERS_LIST, new UsersList());
        repository.put(CommandName.EDIT_MARKS, new EditMarks());
        repository.put(CommandName.EDIT_INFO, new EditInfo());
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
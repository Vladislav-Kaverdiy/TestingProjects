package servlets.commands;

import java.util.Arrays;
import java.util.Optional;

public enum CommandTypes {

    MANAGE_DEPARTMENT("manageDepartment"),
    MANAGE_WORKER("manageWorker"),
    CREATE_DEPARTMENT("createDepartment"),
    EDIT_DEPARTMENT("editDepartment"),
    ADD_WORKER("addWorker"),
    SHOW_WORKER("showWorker"),
    SHOW_EDIT_WORKER("showEditWorker"),
    SHOW_DELETE_WORKER("showDeleteWorker"),
    SHOW_DELETE_DEPARTMENT("showDeleteDepartment"),
    SHOW_EDIT_DEPARTMENT("showEditDepartment"),
    DELETE("delete"),
    EDIT_WORKER("editWorker");


    private String commandName;

    CommandTypes(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return this.commandName;
    }

    public static CommandTypes getType(String value){
        Optional<CommandTypes> cm = Arrays.stream( CommandTypes.values()).filter(name -> name.getCommandName().equals(value))
                .findFirst();
        return cm.isPresent() ? cm.get() : null;
    }

}


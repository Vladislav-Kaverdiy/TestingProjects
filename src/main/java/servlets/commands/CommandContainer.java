package servlets.commands;

import org.apache.log4j.Logger;
import servlets.commands.commandsShow.department.ShowDeleteDepartment;
import servlets.commands.commandsShow.department.ShowEditDepartment;
import servlets.commands.commandsShow.worker.ShowDeleteWorker;
import servlets.commands.commandsShow.worker.ShowEditWorker;
import servlets.commands.commandsShow.worker.ShowWorker;
import servlets.commands.departments.*;
import servlets.commands.workers.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<CommandTypes, Command> commands = new HashMap<>();


    static {
        commands.put(CommandTypes.MANAGE_DEPARTMENT, new ManageDepartment());
        commands.put(CommandTypes.MANAGE_WORKER, new ManageWorker());
        commands.put(CommandTypes.CREATE_DEPARTMENT, new CreateDepartment());
        commands.put(CommandTypes.EDIT_DEPARTMENT, new EditDepartment());
        commands.put(CommandTypes.ADD_WORKER, new AddWorker());
        commands.put(CommandTypes.EDIT_WORKER, new EditWorker());
        commands.put(CommandTypes.SHOW_WORKER, new ShowWorker());
        commands.put(CommandTypes.SHOW_EDIT_WORKER, new ShowEditWorker());
        commands.put(CommandTypes.SHOW_DELETE_WORKER, new ShowDeleteWorker());
        commands.put(CommandTypes.SHOW_EDIT_DEPARTMENT, new ShowEditDepartment());
        commands.put(CommandTypes.SHOW_DELETE_DEPARTMENT, new ShowDeleteDepartment());
        commands.put(CommandTypes.DELETE, new Delete());
    }

    public static Command get(CommandTypes commandTypes) {
        return commands.get(commandTypes);
    }


}
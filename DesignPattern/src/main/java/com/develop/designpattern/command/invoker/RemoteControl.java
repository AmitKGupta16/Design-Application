package com.develop.designpattern.command.invoker;

import com.develop.designpattern.command.Command;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class RemoteControl {
    private List<Command> commands;
    private Command command;

    public void pressButton() {
        command.execute();
    }
    public void pressUndoButton() {
        command.undo();
    }
    public void pressRedoButton() {
        command.redo();
    }
    public void addCommand(Command command) {
        if(commands == null) commands = new ArrayList<Command>();
        commands.add(command);
    }
    public void removeCommand(Command command) {
        commands.remove(command);
    }
    public void executeCommands() {
        commands.forEach(Command::execute);
    }
}

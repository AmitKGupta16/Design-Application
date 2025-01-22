package com.develop.designpattern.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}

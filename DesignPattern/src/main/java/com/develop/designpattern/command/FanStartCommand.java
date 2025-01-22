package com.develop.designpattern.command;

import com.develop.designpattern.command.service.Fan;

public class FanStartCommand implements Command {
    private Fan fan;
    public FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }

    @Override
    public void undo() {
        fan.stop();
    }

    @Override
    public void redo() {
        fan.start();
    }
}

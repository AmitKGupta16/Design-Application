package com.develop.designpattern.command;

import com.develop.designpattern.command.service.Fan;

public class FanStopCommand implements Command {
    private Fan fan;
    public FanStopCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }

    @Override
    public void undo() {
        fan.start();
    }

    @Override
    public void redo() {
        fan.stop();
    }
}

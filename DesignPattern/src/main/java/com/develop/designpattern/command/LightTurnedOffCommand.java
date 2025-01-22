package com.develop.designpattern.command;

import com.develop.designpattern.command.service.Light;

public class LightTurnedOffCommand implements Command {
    private Light light;

    public LightTurnedOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }

    @Override
    public void redo() {
        light.turnOff();
    }
}

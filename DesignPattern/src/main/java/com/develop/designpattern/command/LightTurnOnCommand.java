package com.develop.designpattern.command;

import com.develop.designpattern.command.service.Light;

public class LightTurnOnCommand implements Command {
    private Light light;
    public LightTurnOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

    @Override
    public void redo() {
        light.turnOn();
    }
}

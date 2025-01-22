package com.develop.designpattern.command.client;

import com.develop.designpattern.command.Command;
import com.develop.designpattern.command.FanStartCommand;
import com.develop.designpattern.command.LightTurnOnCommand;
import com.develop.designpattern.command.invoker.RemoteControl;
import com.develop.designpattern.command.service.Fan;
import com.develop.designpattern.command.service.Light;

public class RemoteControlUser {
    public static void main(String[] args) {
        Command lightTurnOn = new LightTurnOnCommand(new Light());
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightTurnOn);
        remoteControl.pressButton();
        remoteControl.pressUndoButton();
        remoteControl.pressRedoButton();
        Command fanStart = new FanStartCommand(new Fan());
        remoteControl.setCommand(fanStart);
        remoteControl.pressButton();
        remoteControl.pressUndoButton();
        remoteControl.pressRedoButton();

        remoteControl.addCommand(fanStart);
        remoteControl.addCommand(lightTurnOn);
        remoteControl.executeCommands();
    }
}

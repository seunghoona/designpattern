package command;

import command.pratice.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRemoteControlTest {

    @Test
    void simpleRemoteLightOnOffTest() {
        // 인보커 역할
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // 요청을 받아 처리할 리시버 개체를 생성 Light
        // new LightOnCommand 커맨드 객체를 생성
        simpleRemoteControl.setCommand(new LightOnCommand(new Light()));
        simpleRemoteControl.buttonWasPressed();
    }

    @Test
    void GarageDorrOpenCommandTest() {
        // 인보커 역할
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // 요청을 받아 처리할 리시버 개체를 생성 Light
        // new LightOnCommand 커맨드 객체를 생성
        simpleRemoteControl.setCommand(new GarageDorrOpenCommand(new GarageDoor()));
        simpleRemoteControl.buttonWasPressed();
    }

    @Test
    void StereoOnWithCDCommandTest() {
        // 인보커 역할
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // 요청을 받아 처리할 리시버 개체를 생성 Light
        // new LightOnCommand 커맨드 객체를 생성
        simpleRemoteControl.setCommand(new StereoOnWithCDCommand(new StereoOnWithCD()));
        simpleRemoteControl.buttonWasPressed();
    }

    @Test
    void remoteControlTest() {
        // 인보커 역할
        RemoteControl remoteControl = new RemoteControl();
        // 요청을 받아 처리할 리시버 개체를 생성 Light
        // new LightOnCommand 커맨드 객체를 생성
        Light light = new Light();
        remoteControl.setCommand(1,new LightOffCommand(light), new LightOffCommand(light));
        GarageDoor garageDoor = new GarageDoor();
        remoteControl.setCommand(2,new GarageDorrOpenCommand(garageDoor), new GarageDorrCloseCommand(garageDoor));
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
    }

}
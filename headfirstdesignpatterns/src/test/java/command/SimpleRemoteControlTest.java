package command;

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

}
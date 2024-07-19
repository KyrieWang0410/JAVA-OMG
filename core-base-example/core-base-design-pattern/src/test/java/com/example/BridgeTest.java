package com.example;

import com.example.bridge.devices.Device;
import com.example.bridge.devices.Radio;
import com.example.bridge.devices.Tv;
import com.example.bridge.remotes.AdvancedRemote;
import com.example.bridge.remotes.BasicRemote;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BridgeTest {


    @Test
    void test() {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    void testDevice(Device device) {
        log.info("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        log.info("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}

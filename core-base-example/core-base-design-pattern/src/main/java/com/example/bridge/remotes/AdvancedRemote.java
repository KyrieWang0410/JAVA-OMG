package com.example.bridge.remotes;

import com.example.bridge.devices.Device;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        log.info("Remote: mute");
        device.setVolume(0);
    }
}

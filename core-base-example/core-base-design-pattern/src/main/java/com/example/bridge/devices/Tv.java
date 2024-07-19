package com.example.bridge.devices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tv implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        log.info("------------------------------------");
        log.info("| I'm TV set.");
        log.info("| I'm " + (on ? "enabled" : "disabled"));
        log.info("| Current volume is " + volume + "%");
        log.info("| Current channel is " + channel);
        log.info("------------------------------------\n");
    }
}

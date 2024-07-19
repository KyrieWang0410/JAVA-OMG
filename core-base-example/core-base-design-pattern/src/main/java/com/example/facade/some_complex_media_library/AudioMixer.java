package com.example.facade.some_complex_media_library;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class AudioMixer {
    public File fix(VideoFile result) {
        log.info("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}

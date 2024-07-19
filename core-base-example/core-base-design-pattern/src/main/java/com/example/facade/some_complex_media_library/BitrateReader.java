package com.example.facade.some_complex_media_library;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        log.info("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        log.info("BitrateReader: writing file...");
        return buffer;
    }
}

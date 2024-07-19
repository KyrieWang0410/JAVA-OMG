package com.example.facade.some_complex_media_library;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if ("mp4".equals(type)) {
            log.info("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            log.info("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}

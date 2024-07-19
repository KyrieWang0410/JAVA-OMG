package com.example.facade.facade;

import com.example.facade.some_complex_media_library.AudioMixer;
import com.example.facade.some_complex_media_library.BitrateReader;
import com.example.facade.some_complex_media_library.Codec;
import com.example.facade.some_complex_media_library.CodecFactory;
import com.example.facade.some_complex_media_library.MPEG4CompressionCodec;
import com.example.facade.some_complex_media_library.OggCompressionCodec;
import com.example.facade.some_complex_media_library.VideoFile;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 外观提供了进行视频转换的简单接口
 */
@Slf4j
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
       log.info("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if ("mp4".equals(format)) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
       log.info("VideoConversionFacade: conversion completed.");
        return result;
    }
}

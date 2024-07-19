package com.example;

import com.example.facade.facade.VideoConversionFacade;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@Slf4j
@SpringBootTest
class FacadeTest {

    /**
     * 在本例中， 外观简化了复杂视频转换框架所进行的沟通工作。
     * 外观提供了仅包含一个方法的类， 可用于处理对框架中所需类的配置与以正确格式获取结果的复杂工作。
     */
    @Test
    void test() {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}

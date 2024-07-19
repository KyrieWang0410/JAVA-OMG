package com.example;

import com.example.builder.builders.CarBuilder;
import com.example.builder.builders.CarManualBuilder;
import com.example.builder.cars.Car;
import com.example.builder.cars.Manual;
import com.example.builder.director.Director;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BuildersTest {
    @Test
    void test() {
        /*
          客户端 （Client） 必须将某个生成器对象与主管类关联。
          一般情况下， 你只需通过主管类构造函数的参数进行一次性关联即可。
          此后主管类就能使用生成器对象完成后续所有的构造任务。
          但在客户端将生成器对象传递给主管类制造方法时还有另一种方式。
          在这种情况下， 你在使用主管类生产产品时每次都可以使用不同的生成器。
         */
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        log.info("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        log.info("\nCar manual built:\n" + carManual.print());
    }
}

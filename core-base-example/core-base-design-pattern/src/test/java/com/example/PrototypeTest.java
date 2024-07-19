package com.example;

import com.example.prototype.caching.cache.BundledShapeCache;
import com.example.prototype.shapes.Circle;
import com.example.prototype.shapes.Rectangle;
import com.example.prototype.shapes.Shape;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class PrototypeTest {

    @Test
    void test() {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }


    @Test
    void test2() {
        BundledShapeCache cache = new BundledShapeCache();

        Shape shape1 = cache.get("Big green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            log.info("Big green circle != Medium blue rectangle (yay!)");
        } else {
            log.info("Big green circle == Medium blue rectangle (booo!)");
        }

        if (shape2 != shape3) {
            log.info("Medium blue rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                log.info("And they are identical (yay!)");
            } else {
                log.info("But they are not identical (booo!)");
            }
        } else {
            log.info("Rectangle objects are the same (booo!)");
        }
    }

    private void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                log.info(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    log.info(i + ": And they are identical (yay!)");
                } else {
                    log.info(i + ": But they are not identical (booo!)");
                }
            } else {
                log.info(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}

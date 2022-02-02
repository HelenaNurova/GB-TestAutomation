package ru.gb.lesson.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.lesson.lesson4.providers.InvalidTriangleProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
@DisplayName("Площадь треугольника")
public class CountAreaTest {

    @Test
    @Disabled("Перенесен в параметризированный тест")
    @DisplayName("Площадь треугольника: прямоугольный треугольник")
    public void countAreaOfEgyprTriangleTest() {
        Triangle triangle = new Triangle(3, 4, 5);
        int square = triangle.countSquare();
        assertEquals(6, square);
    }

    @Test
    @Disabled("Перенесен в параметризированный тест")
    @DisplayName("Площадь треугольника: равносторонний треугольник")
    public void countAreaOfTriangleWithSameSidesTest() {
        Triangle triangle = new Triangle(7, 7, 7);
        int square = triangle.countSquare();
        assertEquals(16, square);
    }

    @Test
    @Disabled("Перенесен в параметризированный тест")
    @DisplayName("Площадь треугольника: тупоугольный треугольник")
    public void angleGraterThan90Test() {
        Triangle triangle = new Triangle(3, 6, 5);
        int square = triangle.countSquare();
        assertEquals(7, square);
    }

    public static Stream<Arguments>triangles(){
    return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
            Arguments.of(new Triangle(7, 7, 7), 16),
            Arguments.of(new Triangle(3, 6, 5), 7)
    );
    }


    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("triangles")
    public void countTriangleAreaTest(Triangle triangle, int expectedSquare) {
        int square = triangle.countSquare();
        assertEquals(expectedSquare, square);
    }
}
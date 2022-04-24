package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    void 자동차_이름이_공백인_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 자동차_이름이_5글자를_초과하는_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Car("테스트자동차"));
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("hello");
        car.doRound(5);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void 자동차_멈춤() {
        Car car = new Car("hello");
        car.doRound(3);
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void 자동차_전진후_상태() {
        Car car = new Car("hello");
        car.doRound(5);
        assertEquals(car.getCurrentStatus(), "hello : -");
    }
}

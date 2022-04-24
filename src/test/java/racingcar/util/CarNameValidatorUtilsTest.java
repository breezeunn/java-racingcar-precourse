package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameValidatorUtilsTest {


    @Test
    void 자동차_이름이_공백인_경우() {
        assertThrows(IllegalArgumentException.class, () -> CarNameValidatorUtils.validateCarName(null));
    }

    @Test
    void 자동차_이름이_5글자를_초과하는_경우() {
        assertThrows(IllegalArgumentException.class, () -> CarNameValidatorUtils.validateCarName("테스트자동차"));
    }
}
package racingcar.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameInputTest {

    private OutputStream captor;

    private final String errorMessagePrefix = "[ERROR]";

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 자동차이름_콤마만_입력할_경우() {
        String testData = ",,,";
        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.isValidRacingCarNames(testData);
            assertTrue(output().startsWith(errorMessagePrefix));
        });
    }

    @Test
    void 자동차이름_아무것도_입력하지_않은_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.isValidRacingCarNames(null);
            assertTrue(output().startsWith(errorMessagePrefix));
        });
    }

    @Test
    void 시도회수_아무것도_입력하지_않은_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.isValidRacingCarCount(null);
            assertTrue(output().startsWith(errorMessagePrefix));
        });
    }

    @Test
    void 시도회수_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.isValidRacingCarCount("hello");
            assertTrue(output().startsWith(errorMessagePrefix));
        });
    }
}

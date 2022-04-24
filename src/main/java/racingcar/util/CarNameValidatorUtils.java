package racingcar.util;

import org.junit.platform.commons.util.StringUtils;

public class CarNameValidatorUtils {

    private CarNameValidatorUtils() { }

    public static void validateCarName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

}

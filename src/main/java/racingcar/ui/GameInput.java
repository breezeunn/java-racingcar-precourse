package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class GameInput {

    private static final String errorMessagePrefix = "[ERROR]";

    public static String getRacingCarNames() {
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            input = Console.readLine();
        } while (!isValidRacingCarNames(input));
        return input;
    }

    public static int getRacingCarGameCount() {
        String input;
        do {
            System.out.println("시도할 회수");
            input = Console.readLine();
        } while (!isValidRacingCarCount(input));
        return Integer.parseInt(input);
    }

    public static boolean isValidRacingCarNames(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "이름이 입력되지 않았습니다.");
        }

        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "이름이 입력되지 않았습니다.");
        }

        return true;
    }

    public static boolean isValidRacingCarCount(String input) {
        int num = getNumber(input);
        if (num < 1 || num > 100) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "시도 회수는 1부터 100까지 입력 가능합니다.");
        }

        return true;
    }

    private static int getNumber(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "시도 회수는 숫자여야 한다.");
        }
        return num;
    }
}

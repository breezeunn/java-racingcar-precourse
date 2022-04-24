package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class GameInput {

    public static String getRacingCarNames() {
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = Console.readLine();
        } while (!isValidRacingCarNames(input));
        return input;
    }

    public static int getRacingCarGameCount() {
        String input;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            input = Console.readLine();
        } while (!isValidRacingCarCount(input));
        return Integer.parseInt(input);
    }

    public static boolean isValidRacingCarNames(String input) {
        try {
            validateCarNameInput(input);
            String[] names = input.split(",");
            for (String name : names) {
                validateCarName(name);
            }
        } catch (Exception e) {
            GameOutput.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateCarNameInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    private static void validateCarName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public static boolean isValidRacingCarCount(String input) {
        int num = getNumber(input);
        if (num < 1 || num > 100) {
            throw new IllegalArgumentException("시도 회수는 1부터 100까지 입력 가능합니다.");
        }

        return true;
    }

    private static int getNumber(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 회수는 숫자여야 합니다.");
        }
        return num;
    }
}

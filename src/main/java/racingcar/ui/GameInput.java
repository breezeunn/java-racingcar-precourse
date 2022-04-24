package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ValidationUtils;

public class GameInput {

    public static String getRacingCarNames() {
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = Console.readLine();
        } while (!ValidationUtils.isValidRacingCarNames(input));
        return input;
    }

    public static int getRacingCarGameCount() {
        String input;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            input = Console.readLine();
        } while (!ValidationUtils.isValidRacingCarRound(input));
        return Integer.parseInt(input);
    }

}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;

public class Car {

    private final String errorMessagePrefix = "[ERROR]";

    private final String name;

    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "이름이 유효하지 않습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "이름은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    public void doRound() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        doRound(randomNumber);
    }

    public void doRound(int randomNumber) {
        validateRandomNumber(randomNumber);
        if (randomNumber >= 4) {
            forward();
        }
    }

    public void validateRandomNumber(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException(errorMessagePrefix + " " + "랜덤 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void forward() {
        this.position++;
    }

    public String getCurrentStatus() {
        StringBuilder status = new StringBuilder(name);
        status.append(" : ");
        for (int i = 1; i <= getPosition(); i++) {
            status.append("-");
        }
        return status.toString();
    }
}

package racingcar.model;

public class Game {

    private final Cars cars;

    private final int totalRound;

    public Game(String nameInput, int totalRound) {
        cars = new Cars();
        String[] names = nameInput.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.totalRound = totalRound;
    }

    public void run() {
        cars.doRound();
        System.out.print(cars.getCarsStatus());
    }

    public String getWinnerName() {
        return this.cars.getWinnersName(cars.getMaxScore());
    }

    public int getTotalRound() {
        return this.totalRound;
    }
}

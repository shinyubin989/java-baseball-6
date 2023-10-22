package baseball;

import java.util.ArrayList;
import java.util.List;

final class Digits {
    private List<Digit> digits;

    private Digits() {
    }

    static Digits generateRandomDigits() {
        Digits randomDigits = new Digits();
        randomDigits.digits = new ArrayList<>();
        while (randomDigits.digits.size() < Size.THREE.num) {
            Digit randomDigit = new Digit();
            if (!randomDigits.digits.contains(randomDigit)) randomDigits.digits.add(randomDigit);
        }
//        System.out.println(random.digits.get(0).digit + " " + random.digits.get(1).digit + " " + random.digits.get(2).digit);
        return randomDigits;
    }

    //TODO : 정적팩터리로?
    static Digits generateFixedDigits(String input) {
        if(input.length() != Size.THREE.num) throw new IllegalArgumentException();
        Digits fixedDigits = new Digits();
        fixedDigits.digits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Digit digit = new Digit(input.charAt(i));
            if (fixedDigits.digits.contains(digit)) throw new IllegalArgumentException();
            fixedDigits.digits.add(digit);
        }
        return fixedDigits;
    }

    //TODO : strike점수가 빠져야함
    int countBall(Digits target) {
        int ballCount = 0;
        for (Digit it : target.digits) {
            if (digits.contains(it)) ballCount++;
        }
        return ballCount;
    }

    int countStrike(Digits target) {
        int strikeCount = 0;
        for (int i = 0; i < target.digits.size(); i++) {
            if (digits.get(i).equals(target.digits.get(i))) strikeCount++;
        }
        return strikeCount;
    }
}

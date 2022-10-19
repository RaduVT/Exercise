public class Dni {
    private static final char[] LETTERS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    private int number;
    private char letter;

    public Dni() {
        number = 0;
        letter = LETTERS[0];
    }

    public Dni(int number, char letter) {
        this.number = number;
        this.letter = toUppercase(letter);
        markErrorIfWrong(number, letter);
    }

    private char toUppercase(char letter) {
        return ("" +letter).toUpperCase().charAt(0);
    }
    private void markErrorIfWrong(int number, char letter) {
        char correctLetter = Dni.letterForDni(number);
        if (letter != correctLetter) {
            this.number = -number;
        }
    }

    public Dni(int number) {
        this.number = number;
        letter = Dni.letterForDni(number);
    }

    public static char letterForDni(int number) {
        return LETTERS[number % 23];
    }

    public Dni(String s) {
        letter = s.charAt(s.length() - 1);
        letter = toUppercase(letter);
        String numberString = s.substring(0, s.length() - 2);
        number = Integer.parseInt(numberString);
        markErrorIfWrong(number, letter);
    }

    @Override
    public String toString() {
        return number + "" + letter;
    }

    public boolean isCorrect() {
        return number >= 0;
    }

    public String toFormattedString() {
        String numS = "" + number;
        String s = "";
        int counter = 0;
        for (int i = numS.length() - 1; i >= 0; i--) {
            s = numS.charAt(i) + s;
            counter ++;
            if (counter == 3) {
                //Insert pont??
                if (i!= 0) {
                    s = '.' + s;
                    counter = 0;
                }
            }
        }
        s = s + "-" + letter;
        return s;
    }
}

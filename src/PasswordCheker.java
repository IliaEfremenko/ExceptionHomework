import java.util.Scanner;

public class PasswordCheker {

    private int minLength;
    private int maxRepeat;

    public boolean setMinLength(int len) {
        if (len < 1) {
            throw new IllegalArgumentException();
        }
        minLength = len;
        return true;
    }

    public boolean setMaxRepeat(int len) {
        if (len < 1) {
            throw new IllegalArgumentException();
        }
        maxRepeat = len;
        return true;
    }

    public boolean checkMinLenghtOf(String password) {
        if (password.length() < minLength) {
            return false;
        }
        return true;
    }

    public boolean cheakMaxRepeatOf(String password) {
        int counter = 1;
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                counter++;
                if (counter >= maxRepeat) {
                    return false;
                }
            } else {
                counter = 1;
            }
        }
        return true;
    }

    public boolean verify(String password) {
        if (minLength == 0) {
            throw new IllegalStateException();
        }
        if (maxRepeat == 0) {
            throw new IllegalStateException();
        }
        return checkMinLenghtOf(password) && cheakMaxRepeatOf(password);
    }
}

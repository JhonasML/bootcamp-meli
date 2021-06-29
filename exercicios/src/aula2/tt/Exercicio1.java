package aula2.tt;

import java.util.IllegalFormatException;
import java.util.regex.Pattern;

public class Exercicio1 {
    public static void main(String[] args) {
        var pwdFraca = new PasswordFraca();
        var pwdMedia = new PasswordMedia();
        var pwdForte = new PasswordForte();

        try {
            pwdFraca.setValue("");
        } catch (IllegalFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            pwdMedia.setValue("aaaA12");
        } catch (IllegalFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            pwdForte.setValue("a31@aa");
        } catch (IllegalFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Password {
    private String regex;
    private Pattern pattern;
    private String pwd;

    public Password(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public void setValue(String pwd) throws IllegalFormatException {
        if (pattern.matcher(pwd).matches()){
            this.pwd = pwd;
        }else {
            throw new IllegalArgumentException();
        }
    }
}

class PasswordFraca extends Password {
    public PasswordFraca() {
        super("\\w*");
    }

}

class PasswordMedia extends Password {
    public PasswordMedia() {
        super("((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,}))");
    }
}

class PasswordForte extends Password {
    public PasswordForte() {
        super("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,})");
    }
}
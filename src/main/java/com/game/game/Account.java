package com.game.game;


import java.io.BufferedReader;
import java.io.FileReader;

public class Account {
    String nickname;
    String password;
    int characterCount;

    public Account(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    private boolean charCountCheck() {
        return characterCount < 3;
    }

    public boolean accountValidation() {        //Я ЗНАЮ ЧТО МЕТОД УЖАС И НЕ ПО СОЛИД ПРИНЦИПАМ, Я ИСПРАВЛЮСЬ, ПОЩАДИТЕ
        try {
            FileReader accountsReader = new FileReader("src\\main\\resources\\com\\game\\game\\Accounts.txt");
            BufferedReader reader = new BufferedReader(accountsReader);

            StringBuilder login = new StringBuilder();
            StringBuilder password = new StringBuilder();
            String accountLine = reader.readLine().replace(" ", "");

            while (accountLine != null) {
                login.delete(0, login.length() + 1);
                password.delete(0, password.length() + 1);
                for (int i = 0; i < accountLine.length(); i++) {
                    if (accountLine.charAt(i) == '-') {
                        i++;
                        while (i < accountLine.length()) {
                            if (accountLine.charAt(i) == '=') {
                                break;
                            }
                            password.append(accountLine.charAt(i));
                            i++;
                        }
                        if (accountLine.charAt(i) == '=') {
                            i++;
                            characterCount = Integer.parseInt(Character.toString(accountLine.charAt(i)));
                            break;
                        }
                    }
                    login.append(accountLine.charAt(i));
                }
                if (login.toString().equals(nickname) && password.toString().equals(this.password)) {
                    break;
                }
                try {
                    accountLine = reader.readLine().replace(" ", "");
                } catch (Exception e) {
                    break;
                }
            }
            return login.toString().equals(nickname) && password.toString().equals(this.password);
        } catch (Exception e) {
            return false;
        }
    }
}

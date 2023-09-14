package com.game.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.FileReader;

public class ChooseCharacterController {
    @FXML
    Button firstCharacter;
    @FXML
    Button secondCharacter;
    @FXML
    Button thirdCharacter;

    public ChooseCharacterController() {
        characterCheck();
    }

    private void characterCheck() {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\com\\game\\game\\accounts\\data\\"
                    + LogInController.account.nickname + ".txt");
            BufferedReader reader = new BufferedReader(fileReader);


            StringBuilder characterClass = new StringBuilder();
            StringBuilder characterName = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                String character = reader.readLine().replace(" ", "");
                for (int j = 0; j < character.length(); j++) {
                    if (character.charAt(j) == '-') {
                        j++;
                        while (j < character.length()) {
                            characterName.append(character.charAt(j));
                            j++;
                        }
                        break;
                    }
                    characterClass.append(character.charAt(j));
                }
                switch (characterClass.toString()) {
                    case "Wizard" -> {
                        Character wizard = new Wizard(characterName.toString());
                        firstCharacter.setText("");
                    }
                    case "Hunter" -> {
                        Character hunter = new Hunter();
                    }
                    case "Warrior" -> {
                        Character warrior = new Warrior();
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}

package com.compass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        // Usuários presentes no sistema
        users.add(new User("João", "123456"));
        users.add(new User("Maria", "123456789"));
        users.add(new User("José", "uma_senha_difícil?"));
        users.add(new User("Vinicios", "senha com espaço"));

        String nameInput = "";
        String passwordInput = "";
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Usuário: ");
            nameInput = input.nextLine();
            System.out.print("Senha: ");
            passwordInput = input.nextLine();
            input.close();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro");
        }

        boolean hasUser = false;
        for (User user : users) {
            if (user.login(nameInput, passwordInput)) {
                System.out.println(greetingsMessage());
                hasUser = true;
                break;
            }
        }

        if (!hasUser)
            System.err.println("Usuário e/ou senha incorretos.");

    }

    /**
     * Gera a mensagem de boas vindas de acordo com o horário
     * 
     * @return mensagem de boas vindas
     */
    public static String greetingsMessage() {
        int hour = LocalDateTime.now().getHour();

        if (hour < 6)
            return "Boa madrugada, você se logou ao nosso sistema.";

        if (hour < 12)
            return "Bom dia, você se logou ao nosso sistema";

        if (hour < 18)
            return "Boa tarde, você se logou ao nosso sistema.";

        return "Boa noite, você se logou ao nosso sistema.";
    }

}
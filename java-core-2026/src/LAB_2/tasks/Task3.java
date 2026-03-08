package LAB_2.tasks;

import java.util.Scanner;

/**
 * Напишите программу «Шифр Цезаря», которая зашифровывает
 * введенный текст. Используете кодовую таблицу символов. При запуске
 * программы в консоль необходимо вывести сообщение: «Введите текст для
 * шифрования», после ввода текста, появляется сообщение: «Введите ключ».
 * После того как введены все данные, необходимо вывести преобразованную
 * строку с сообщением «Текст после преобразования: ». Далее необходимо
 * задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)»,
 * если пользователь вводит «y», тогда выполнить обратное преобразование.
 * Если пользователь вводит «n», того программа выводит сообщение «До
 * свидания!». Если пользователь вводит что-то другое, отличное от «y» или «n»,
 * то программа ему выводит сообщение: «Введите корректный ответ».
 *
 * Стоит уточнить, нужно ли внутри задачи сдвигаться в рамках всей кодовой таблицы UTF-16
 * или нужно только в рамках своего алфавита.
 */
public class Task3 {
    public static String cypherFunc(String text, int key) {
        char [] textChars = text.toCharArray();
        char[] sypheredTextChars = new char[textChars.length];

        for (int i = 0; i < textChars.length; i++) {
            sypheredTextChars[i] = (char) (textChars[i] + key);
        }

        return new String(sypheredTextChars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text, flag, cipheredText, decipheredText;
        int encryptionKey;

        System.out.println("Введите текст для шифрования: ");
        text = in.nextLine();
        System.out.println("Введите ключ шифрования: ");
        // более безопасный способ считывания, потому что при преобразовании убирает ненужный символы
        // типа переноса строки - in.nextInt() оставлял в потоке чтения символ \n
        encryptionKey = Integer.parseInt(in.nextLine());

        cipheredText = cypherFunc(text, encryptionKey);
        System.out.println("Текст после преобразования: ");
        System.out.println(cipheredText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        flag = in.nextLine();

        if (flag.equals("y")) {
            decipheredText = cypherFunc(cipheredText, encryptionKey * -1);
            System.out.println(decipheredText);
        } else if (flag.equals("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ...");
        }
    }
}

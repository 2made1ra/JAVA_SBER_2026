package lab6.tasks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Задание 1.
 * Напишите программу, которая запускает два потока и выводит на экран их имена
 * и текущее время в течение 10 секунд.
 */
public class Task1 {
    private static final long WORK_TIME_MILLIS = 10_000;
    private static final long DELAY_MILLIS = 1_000;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static Thread createTimePrinter(String threadName, long workTimeMillis, long delayMillis) {
        return new Thread(() -> printCurrentTime(workTimeMillis, delayMillis), threadName);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = createTimePrinter("First thread", WORK_TIME_MILLIS, DELAY_MILLIS);
        Thread secondThread = createTimePrinter("Second thread", WORK_TIME_MILLIS, DELAY_MILLIS);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();
    }

    private static void printCurrentTime(long workTimeMillis, long delayMillis) {
        long finishTime = System.currentTimeMillis() + workTimeMillis;

        while (System.currentTimeMillis() < finishTime) {
            System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now().format(TIME_FORMATTER));
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

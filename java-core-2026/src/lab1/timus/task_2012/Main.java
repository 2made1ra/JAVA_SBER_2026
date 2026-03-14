package lab1.timus.task_2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);

        byte total = 12;
        String result = "NO";
        byte f = Byte.parseByte(st.nextToken());

        byte remainTasksTime = 4 * 60 / 45;
        byte needToCompleteFirstHour = (byte) (total - remainTasksTime);

        if (f >= needToCompleteFirstHour) {
            result = "YES";
        }

        out.println(result);
        out.flush();
    }
}

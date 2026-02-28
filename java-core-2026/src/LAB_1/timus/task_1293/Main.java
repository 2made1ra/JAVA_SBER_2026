package LAB_1.timus.task_1293;

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

        byte N = Byte.parseByte(st.nextToken());
        byte A = Byte.parseByte(st.nextToken());
        byte B = Byte.parseByte(st.nextToken());

        int result = N * A * B * 2;

        out.println(result);
        out.flush();
    }
}

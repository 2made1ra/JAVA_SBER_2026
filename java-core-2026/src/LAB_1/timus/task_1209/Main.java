package LAB_1.timus.task_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreElements()) {
                String nextLine = br.readLine();
                if (nextLine == null) break;
                st = new StringTokenizer(nextLine);
            }

            assert st != null;
            long k = Long.parseLong(st.nextToken());
            long d = 8 * k - 7;
            long sqrtD = (long) Math.sqrt(d);

            if (sqrtD * sqrtD == d) {
                out.print("1 ");
            } else {
                out.print("0 ");
            }
        }

        out.flush();
        out.close();
        br.close();
    }
}

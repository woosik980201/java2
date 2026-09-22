package ai0922;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LAB_SecureTest {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String line = "";
            FileWriter fw = new FileWriter("secure.txt");

            while (true) {
                System.out.print("스파이에게 전달할 메시지 입력 (종료: Enter): ");
                line = s.nextLine();

                // 아무것도 입력하지 않고 Enter를 누르면 종료
                if (line.equals(""))
                    break;

                // 새로운 문장을 입력할 때마다 초기화
                String secure = "";

                // 문자 하나씩 암호화
                for (int i = 0; i < line.length(); i++) {
                    int num = (int) line.charAt(i);
                    num += 100;
                    secure += (char) num;
                }

                // 암호화된 문자열 파일에 저장
                fw.write(secure + "\n");
            }

            fw.close();
            s.close();

            System.out.println("암호화 완료 → secure.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LAB_DecodeSecureTest {
    public static void main(String[] args) {
        try {
            String line = "";

            BufferedReader br =
                    new BufferedReader(new FileReader("secure.txt"));

            FileWriter fw =
                    new FileWriter("decodeSecure.txt");

            while (true) {
                line = br.readLine();

                // 파일의 끝까지 읽었으면 종료
                if (line == null)
                    break;

                // 새로운 줄을 읽을 때마다 초기화
                String decode = "";

                // 문자 하나씩 복호화
                for (int i = 0; i < line.length(); i++) {
                    int num = (int) line.charAt(i);
                    num -= 100;
                    decode += (char) num;
                }

                // 복호화된 문자열 파일에 저장
                fw.write(decode + "\n");
            }

            br.close();
            fw.close();

            System.out.println("복호화 완료 → decodeSecure.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
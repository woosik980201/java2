
package center;

import javax.swing.*;
import java.awt.*;

public class SetFrame {

    public static void setFrame(JFrame frame, String title, int w, int h) {

        // 프레임 제목 설정
        frame.setTitle(title);

        // 종료 버튼 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 화면 중앙 위치 계산
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - w) / 2;
        int y = (screen.height - h) / 2;

        // 프레임 위치 및 크기 설정
        frame.setBounds(x, y, w, h);

        // 프레임 화면 표시
        frame.setVisible(true);
    }
}


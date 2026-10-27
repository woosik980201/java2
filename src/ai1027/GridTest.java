
package ai1027;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;

public class GridTest extends JFrame {

    public GridTest() {

        // GridLayout: 3행 3열, 간격 10px
        setLayout(new GridLayout(3, 3, 10, 10));

        // 버튼 9개 생성
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton("버튼 " + i);
            add(btn);
        }

        SetFrame.setFrame(this, "GridLayout 연습", 250, 250);
    }

    public static void main(String[] args) {
        new GridTest();
    }
}

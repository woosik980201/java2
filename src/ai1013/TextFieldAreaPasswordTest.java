
package ai1013;

import ai0929.gui.CenterFrame;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class TextFieldAreaPasswordTest extends JFrame {

    public TextFieldAreaPasswordTest() {

        setTitle("문자열 입력 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 컴포넌트를 순서대로 배치
        setLayout(new FlowLayout());

        // 한 줄 입력
        JTextField textField = new JTextField("", 20);

        // 여러 줄 입력
        JTextArea area = new JTextArea("", 5, 20);

        // 비밀번호 입력
        JPasswordField passwordField = new JPasswordField(20);

        // 컴포넌트 추가
        add(textField);
        add(area);
        add(passwordField);

        // 창 크기 및 위치
        int w = 250, h = 350;

        Dimension locations = CenterFrame.getLocation(w, h);

        setBounds(locations.width, locations.height, w, h);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldAreaPasswordTest();
    }
}

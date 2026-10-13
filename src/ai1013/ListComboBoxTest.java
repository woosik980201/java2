
package ai1013;

import ai0929.gui.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class ListComboBoxTest extends JFrame {

    public ListComboBoxTest() {

        setTitle("문자열 입력 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        String[] items = {"강아지", "고양이", "토끼", "미어캣", "코알라"};
        JList list = new JList(items);
        JComboBox comboBox = new JComboBox(items);

        add(comboBox);
        add(list);


        // 창 크기 및 위치
        int w = 250, h = 350;

        Dimension locations = CenterFrame.getLocation(w, h);

        setBounds(locations.width, locations.height, w, h);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ListComboBoxTest();
    }
}

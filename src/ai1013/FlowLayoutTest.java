
package ai1013;

import center.centerFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlowLayoutTest extends JFrame {

    // 버튼을 저장할 리스트
    ArrayList<JButton> list = new ArrayList<>(5);

    // 버튼별 변경 색상
    Color[] colors = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE
    };

    // 각 버튼의 색상 변경 상태
    boolean[] flags = new boolean[5];

    public FlowLayoutTest() {

        setTitle("FlowLayout 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 오른쪽 정렬, 수평 및 수직 간격 15
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));

        // 버튼 5개 생성
        for (int i = 0; i < 5; i++) {

            JButton btn = new JButton("버튼" + (i + 1));

            // 초기 배경색
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setOpaque(true);

            // 이벤트 등록
            btn.addActionListener(btnListener);

            // 리스트 저장 및 화면 추가
            list.add(btn);
            add(btn);
        }

        // 창 크기 및 중앙 위치 설정
        int w = 250, h = 250;

        Point point = centerFrame2.getLocation(w, h);

        setBounds(point.x, point.y, w, h);

        setVisible(true);
    }

    // 버튼 클릭 이벤트
    ActionListener btnListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton selectedBtn = (JButton) e.getSource();

            // 클릭한 버튼 확인
            for (int i = 0; i < list.size(); i++) {

                if (selectedBtn == list.get(i)) {

                    if (!flags[i]) {

                        // 첫 클릭: 지정된 색상 적용
                        selectedBtn.setBackground(colors[i]);
                        flags[i] = true;

                    } else {

                        // 다시 클릭: 기본 색상 복원
                        selectedBtn.setBackground(Color.LIGHT_GRAY);
                        flags[i] = false;
                    }

                    break;
                }
            }
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FlowLayoutTest::new);
    }
}

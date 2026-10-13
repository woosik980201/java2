
package ai1013;

import ai0929.gui.CenterFrame;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLabelJButtonImageTest extends JFrame {

    // ==========================================
    // 1. 이미지 불러오기
    // ==========================================

    ImageIcon originalIcon = new ImageIcon("imgs/azi.jpg");

    // 원본 이미지 크기
    int originalWidth = originalIcon.getIconWidth();
    int originalHeight = originalIcon.getIconHeight();

    // 이미지 최대 표시 크기
    int maxWidth = 250;
    int maxHeight = 220;

    // 원본 비율 유지
    double scale = Math.min(
            (double) maxWidth / originalWidth,
            (double) maxHeight / originalHeight
    );

    // 새로운 이미지 크기
    int newWidth = (int) (originalWidth * scale);
    int newHeight = (int) (originalHeight * scale);

    // 이미지 축소
    Image scaledImage = originalIcon.getImage()
            .getScaledInstance(
                    newWidth,
                    newHeight,
                    Image.SCALE_SMOOTH
            );

    ImageIcon lblIcon = new ImageIcon(scaledImage);

    // 중앙 JLabel
    JLabel lbl = new JLabel();

    // 첫 클릭 시 이미지가 나타나도록 설정
    boolean flag = false;

    // ==========================================
    // 2. 생성자
    // ==========================================

    public JLabelJButtonImageTest() {

        setTitle("ImageIcon설정 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 버튼 이미지
        ImageIcon btnIcon = new ImageIcon("imgs/dog_icon.png");

        JButton btn = new JButton("Click Here~", btnIcon);

        // 버튼 이벤트 등록
        btn.addActionListener(btnListener);

        // JLabel 이미지 중앙 정렬
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);

        // 화면 배치
        add("North", btn);
        add("Center", lbl);

        // 창 크기 및 위치
        int w = 350;
        int h = 350;

        Dimension locations = CenterFrame.getLocation(w, h);

        setBounds(
                locations.width,
                locations.height,
                w,
                h
        );

        setVisible(true);
    }

    // ==========================================
    // 3. 버튼 클릭 이벤트
    // ==========================================

    ActionListener btnListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!flag) {
                // 이미지 표시
                lbl.setIcon(lblIcon);
                flag = true;

            } else {
                // 이미지 숨기기
                lbl.setIcon(null);
                flag = false;
            }
        }
    };

    // ==========================================
    // 4. 프로그램 실행
    // ==========================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                JLabelJButtonImageTest::new
        );
    }
}

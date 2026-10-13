
package ai1013;

import ai0929.gui.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxImageTest extends JFrame {

    // JLabel을 클래스 필드로 선언
    JLabel lbl = new JLabel();

    public ComboBoxImageTest() {

        setTitle("콤보박스 이미지 선택");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 콤보박스 항목
        String[] items = {
                "강아지", "고양이", "토끼", "미어캣", "코알라"
        };

        JComboBox<String> comboBox = new JComboBox<>(items);

        // 콤보박스 이벤트 등록
        comboBox.addItemListener(comboListener);

        // 이미지 중앙 정렬
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);

        // 화면 배치
        add("North", comboBox);
        add("Center", lbl);

        // 창 크기 및 위치
        int w = 500, h = 500;

        Dimension locations = CenterFrame.getLocation(w, h);

        setBounds(locations.width, locations.height, w, h);

        // 첫 번째 항목 이미지 표시
        showImage(1);

        setVisible(true);
    }

    // 콤보박스 선택 이벤트
    ItemListener comboListener = new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {

            // 선택된 항목만 처리
            if (e.getStateChange() != ItemEvent.SELECTED) {
                return;
            }

            int imgPath = 0;

            String selectedItem = (String) e.getItem();

            switch (selectedItem) {

                case "강아지":
                    imgPath = 1;
                    break;

                case "고양이":
                    imgPath = 2;
                    break;

                case "미어캣":
                    imgPath = 3;
                    break;

                case "코알라":
                    imgPath = 4;
                    break;

                case "토끼":
                    imgPath = 5;
                    break;
            }

            showImage(imgPath);
        }
    };

    // 이미지 표시 메서드
    private void showImage(int imgPath) {

        if (imgPath == 0) {
            return;
        }

        // 이미지 경로
        String path = String.format("pets/pet%02d.jpg", imgPath);

        ImageIcon icon = new ImageIcon(path);

        // 이미지 파일 확인
        if (icon.getIconWidth() <= 0) {
            lbl.setIcon(null);
            lbl.setText("이미지를 찾을 수 없습니다: " + path);
            return;
        }

        // 원본 이미지 크기
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();

        // 최대 이미지 크기
        int maxWidth = 400;
        int maxHeight = 400;

        // 원본 비율 유지
        double scale = Math.min(
                (double) maxWidth / originalWidth,
                (double) maxHeight / originalHeight
        );

        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        // 이미지 크기 조절
        Image scaledImage = icon.getImage().getScaledInstance(
                newWidth,
                newHeight,
                Image.SCALE_SMOOTH
        );

        // JLabel에 이미지 표시
        lbl.setText("");
        lbl.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComboBoxImageTest::new);
    }
}

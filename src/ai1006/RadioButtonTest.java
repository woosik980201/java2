package ai1006;

import ai0929.gui.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonTest extends JFrame {

    // 클래스 멤버 변수
    ImageIcon[] imageIcons;
    JLabel lbl;
    JRadioButton[] radios;

    public RadioButtonTest() {

        setTitle("라디오버튼 테스트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame 기본 레이아웃
        setLayout(new BorderLayout());


        // ==========================================
        // 상단 라디오 버튼 영역
        // ==========================================

        JPanel panNorth = new JPanel(); // 작은 박스

        String[] entertainers = {
                "아이브",
                "리센느",
                "캣츠아이"
        };

        // 라디오 버튼 배열
        radios = new JRadioButton[entertainers.length];

        // 이미지 배열
        imageIcons = new ImageIcon[entertainers.length];

        // 이미지를 출력할 JLabel
        lbl = new JLabel();

        // 라디오 버튼을 하나의 그룹으로 묶음
        ButtonGroup group = new ButtonGroup();


        // ==========================================
        // 라디오 버튼 및 이미지 생성
        // ==========================================

        int i = 0;

        for (String entertainer : entertainers) {

            // 이미지 불러오기
            imageIcons[i] =
                    new ImageIcon("imgs/img" + i + ".jpg");

            // 라디오 버튼 생성
            radios[i] =
                    new JRadioButton(entertainer);

            // ButtonGroup에 라디오 버튼 추가
            group.add(radios[i]);

            // 이벤트 리스너 연결
            radios[i].addItemListener(radioListener);

            // 패널에 라디오 버튼 추가
            panNorth.add(radios[i++]);
        }


        // ==========================================
        // 기본 이미지 설정
        // ==========================================

        lbl.setIcon(imageIcons[0]);


        // ==========================================
        // JFrame에 컴포넌트 배치
        // ==========================================
        radios[0].setSelected(true);
        lbl.setIcon(imageIcons[0]);
        add("North", panNorth);
        add("Center", lbl);


        // ==========================================
        // JFrame 크기 및 위치 설정
        // ==========================================

        int w = 500;
        int h = 500;

        Dimension location =
                CenterFrame.getLocation(w, h);

        setBounds(
                location.width,
                location.height,
                w,
                h
        );

        setVisible(true);
    }


    // ==========================================
    // main
    // ==========================================

    public static void main(String[] args) {

        new RadioButtonTest();
    }


    // ==========================================
    // 라디오 버튼 이벤트 처리
    // ==========================================

    ItemListener radioListener = new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {

            // 이벤트가 발생한 라디오 버튼 가져오기
            JRadioButton selectedRadio =
                    (JRadioButton) e.getSource();

            // 선택한 라디오 버튼에 따라 이미지 변경
            if (selectedRadio == radios[0]) {

                lbl.setIcon(imageIcons[0]);

            } else if (selectedRadio == radios[1]) {

                lbl.setIcon(imageIcons[1]);

            } else {

                lbl.setIcon(imageIcons[2]);
            }
        }
    };
}
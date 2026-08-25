package ai0825;

import java.util.Random;

public class LABRandomWiseSaying {
    public static void main(String[] args) {
        String[] wiseSay = {
                "인생은 공평하지 않다. 그러니 그냥 익숙해져라. — 빌 게이츠",
                "갖지 못한 것을 부러워하면 마음이 가난해진다. — 미상",
                "느리게 가는 사람이 가장 멀리 간다. — 미상",
                "천재란 자신에게 주어진 일을 하는 재능 있는 사람일 뿐이다. — 토마스 에디슨",
                "나는 행운을 굳게 믿으며, 내가 더 열심히 일할수록 더 많은 행운이 따르곤 한다. — 토마스 제퍼슨",
                "피할 수 없으면 즐겨라. — 로버트 엘리엇",
                "완벽한 준비는 없고, 완벽한 순간도 없다. 그냥 지금 해보는 거다. — 미상",
                "지혜는 듣는 데서 오고, 후회는 말하는 데서 온다. — 미상",
                "어떤 일든 시작해야 비로소 이룰 수 있다. — 미상",
                "만약 지옥을 통과하고 있다면, 멈추지 말고 계속 가라.— 윈스턴 처칠"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(wiseSay.length);
        System.out.println("오늘의 명언: " + wiseSay[randomIndex]);
    }
}

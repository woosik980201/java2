package ai0908;

public class VoidTest {
    public static void printLine(String c, int count){
        for (int i=0; i<count; i++){
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
            String[] emojis = {"❤️","🍕","🤦‍","😶","‍🌫","🤡","☠️"};

        for (int i = 0; i < emojis.length; i++) {
            printLine(emojis[i],(i+1)*10 );
        }
    }
}

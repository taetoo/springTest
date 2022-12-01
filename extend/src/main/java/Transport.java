public class Transport {
    int num;
    int amountOil = 100;
    int speed = 0;
    int speedChange;
    int maxPass;

    void driveStart(){
        System.out.println("운행시작");
    }
    void speedChange(){
        System.out.println("속도변경");
    }
    void stateChange(){
        System.out.println("상태변경");
    }


}


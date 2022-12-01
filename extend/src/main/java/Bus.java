public class Bus extends Transport{
    int currentPass = 5;

    public int getMaxPass() {
        return maxPass = 30;
    }


    void stateChange(){
        System.out.println("운행");
    }


}

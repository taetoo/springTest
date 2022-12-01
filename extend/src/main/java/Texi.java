public class Texi extends Transport{
    int destination;
    int destiDistance;
    int defaultDistance = 1;
    int defaultAmount = 3000;
    int distanceAmount = 1000;

    void addAmount(){
        System.out.println("거리당 요금 추가");
    }
    void payment(){
        System.out.println("요금결제");
    }
    public int getMaxPass() {
        return maxPass = 4;
    }
    public int getAmountOil(){
        return amountOil = 100;
    }
    void stateChange(){
        System.out.println("일반");
    }



}

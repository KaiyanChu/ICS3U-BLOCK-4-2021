package week9;

public class CombineTable {
    private SingleTable table1;
    private SingleTable table2;
    public CombineTable(SingleTable t1, SingleTable t2){
        table1 = t1;
        table2 = t2;
    }
    public Boolean canSeat(int seats){
        return tableOne.getNumSeats() + tableTwo.getNumSeats()
    }
    public double getDesirability(){
        if(table1.height() == table2.height()){
            return ((double)table1.getViewQuality + table2.getViewQuality)/2;
        }
        return (((double)table1.getViewQuality + table2.getViewQuality)/2) - 10;
    }

}

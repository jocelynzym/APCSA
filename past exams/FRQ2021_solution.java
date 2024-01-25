//FRQ 2021

//q1
public class WordMatch
{
    private String secret;
    public WordMatch(String word)
    {}
    // part-a
    public int scoreGuess(String guess){
        int count = 0;
        for(int i=0; i<guess.length(); i++){
            String currentString = secret.substring(i);
            if(currentString.indexOf(guess)>=0) count++;
        }
        return count*guess.length()*guess.length();
    }
    //part-b
    public String findBetterGuess(String guess1, String guess2){
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);
        if(score1>score2) return guess1;
        else if(score1<score2) return guess2;
        else{
            if(guess1.compareTo(guess2)>0) return guess1;
            else return guess2;
        }
    }
}

//q2
public class SingleTable
{
    public int getNumSeats(){};
    public int getHeight(){};
    public double getViewQuality(){};
    public void setViewQuality(double value){};
}

public class CombinedTable
{
    private SingleTable t1;
    private SingleTable t2;

    public CombinedTable(SingleTable table1, SingleTable table2){
        t1 = table1;
        t2 = table2;
    }

    public boolean canSeat(int people){
        int max = t1.getNumSeats()+t2.getNumSeats()-2;
        if(people<=max && people>=0) return true;
        else return false;
    }

    public double getDesirability(){
        if(t1.getHeight() == t2.getHeight()){
            return (t1.getViewQuality()+t2.getViewQuality())/2;
        }else{
             return (t1.getViewQuality()+t2.getViewQuality())/2 - 10 ;
        }
    }
}

//q3
public class MemberInfo
{
    public MemberInfo(String name, int gradYear, boolean hasGoodStanding){
    }
    public int getGradYear(){
    }
    public boolean inGoodStanding(){
    }
}

public class ClubMembers{
    private ArrayList<MemberInfo> memberList;
    //part-a
    public void addMemebers(String[] names, int gradYear)
    {
        for(int i=0; i<names.length; i++){
            MemberInfo newMember = new MemberInfo(names[i], gradYear, true);
            memberList.add(newMember);
        }
    }
    //part-b
    public ArrayList<MemberInfo> removeMembers(int year)
    {
        ArrayList<MemberInfo> goodList = new ArrayList<MemberInfo>();

        for(int i=0; i<memberList.size(); i++){
            if(memberList[i].getGradYear()<= year){
                if(memberList[i].inGoodStanding()){
                    goodList.add(memberList[i]);
                }
                memberList.remove(i);
            }
        }
    }
}


//q4
public class ArrayResizer
{
    //part-a
    public static boolean isNonZeroRow(int[][] array2D, int r){
        boolean flag = true;
        for(int i=0; i<array2D[r].length; i++){
            if(array2D[r][i]==0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int numNonZeroRows(int[][] array2D)
    {}

    //part-b
    public static int[][] resize(int[][] array2D){
        int rowNum = numNonZeroRows(array2D);
        int[][] smaller = new int[rowNum][array2D[0].length];

        int count = 0;
        for(int i=0; i<array2D.length; i++){
            if(isNonZeroRow(array2D,i)){
                for(int j=0; j<smaller[count].length; j++){
                    smaller[count][j] = array2D[i][j];
                }
                count++;
            }
        }
        return smaller;
    }

}



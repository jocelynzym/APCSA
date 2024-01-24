// FRQ2019

//for循环注意边界条件，带入值进行测试
//写一个class的三个步骤: 1.写constructor 2.内部变量private int a = 0; 3.多个method,各个method的作用,每个method记得写return值
//array的长度
//怎样新建一个arraylist
//怎样新建一个1D-array，2D-array：double[] myList = new double[size];
//array长度怎么获取、arraylist长度怎么获取
//判断两个String内容是否相同
//arraylist的遍历
//怎样判断一个数是odd还是even


//每句话后面加 ;
//变量命名全用字母


//q1
public class APCalendar
{
    private static boolean isLeapYear(int year){
    }
    
    // part(a)
    public static int numberOfLeapYears(int year1, int year2){
        int num = 0;
        for(int i = year1; i <= year2; i++){
            if(isLeapYear(i)) num++;
        }
        return num;
    }
    
    private static int firstDayOfYear(int year){
    }
    
    private static int dayOfYear(int month, int day, int year){
    }
    
    // part(b)
    public static int dayOfWeek(int month, int day, int year){
        int firstDay = firstDayOfYear(year); 
        int days = dayOfYear(month, day, year); 
        
        int resume = (days-1)%7; 
        int speDay = (firstDay + resume) % 7;
        return speDay;
    }
    
}

//q2
public class StepTracker{
    private  int goal;
    private  int steps;
    private  int totalDays;
    private  int acDays;
    
    //constructor
    public StepTracker(int num){
        goal = num;
        steps = 0;
        totalDays = 0;
        acDays = 0;
    }
    public void addDailySteps(int num){
        steps += num;
        totalDays++;
        if(num>=goal) acDays++;
    }
    public int activeDays(){
        return acDays;
    }
    public int averageSteps(){
        return steps/totalDays;
    }
    
}


//q3
public class Delimiters{

    private String openDel;
    private String closeDel;
    
    public Delimiters(String open, String close)
    {
        openDel  = open;
        closeDel = close;
    }
    
    //part(a)
    public ArrayList<String> getDelimitersList(String[] tokens){
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<tokens.length; i++){
            if(tokens[i].equals(openDel) or tokens[i].equals(closeDel))
                result.add(tokens[i])
        }
        return result;
    }
    
    //part(b)
    public boolean isBalanced(ArrayList<String> delimiters){
        int openNum = 0;
        int closeNum = 0;
        for(int i=0; i<delimiters.size(); i++){
            if(delimiters[i].equals(openDel)) openNum++;
            else if(delimiters[i].equals(closeDel)) closeNum++;
            if(closeNum > openNum) return false;
        }
        if(closeNum!=openNum) return false;
        return true;
    }
    
}
    

//q4
public class LightBoard{
    private boolean[][] lights;
    
    //part(a)
    public LightBoard(int numRows, int numCols){
        lights = new boolean[numRows][numCols];
        for(int i = 0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                double randomNum = Math.random();
                if(randomNum<0.4) lights[i][j] = true;
                else lights[i][j] = false;
            }
        }
    }
    
    //part(b)
    public boolean evaluateLight(int row, int col){
        # rule1
        int count = 0;
        for(int i=0; i<lights.length; i++){
            if(lights[i][col]) count++;
        }
        if(lights[row][col] && count%2==0) return false; #rule1
        if(!lights[row][col] && count%3==0) return true;  #rule2
        return lights[row][col]; #rule3
        
    }
   
}


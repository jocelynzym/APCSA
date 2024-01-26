//FRQ 2023

//判断array[i][j]是否为空

//q1
public class AppointmentBook
{
    private boolean isMinuteFree(int period, int minute)
    {}
    private void reserveBlock(int period, int startMinute, int duration)
    {}
    //part-a
    public int findFreeBlock(int period, int duration){
        int count = 0;
        for(int i=0; i<60; i++){
           if(isMinuteFree(period,i)){
                count++;
                if(count==duration) return i;
           }else{
                count = 0;
           }
        }
        return -1;
    }
    //part-b
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
        for(int i=startPeriod; i<=endPeriod; i++){
            int startMinute = findFreeBlock(i,duration);
            if(startMinute>-1){
                reserveBlock(i,startMinute,duration)
                return true;
            }
        }
        return false;
    }

}

//q2
public class Sign
{
    private String display;
    private int    width;

    public(String str1, int num){
        display = str1;
        width = num;
    }

    public int numberOfLines(){
        int res = display.length()%width;
        return (display.length()-res)/width + 1;
    }

    public String getLines(){
        int semiNum = numberOfLines()-1;
        String newString;
        for(int i=0; i<semiNum; i++){
            newString += display.subString(i*width,(i+1)*width);
            newString += ";"
        }
        newString += display.subString(semiNum*width);

        return newString;
    }
}



//q3
public class WeatherData
{
    private ArrayList<Double> temperatures;

    //part-a
    public void cleanData(double lower, double upper){
        for(int i=0; i<temperatures.size();i++){
            if(temperatures[i]>upper || temperatures[i]<lower){
                temperatures.remove(i);
            }
        }
    }

    //part-b
    public int longestHeatWave(double threshold){
        int max = 0;
        int count = 0;
        for(int i=0; i<temperatures.size(); i++){
            if(temperatures[i]<=threshold){
                if(count>max) max=count;
                count=0;
            }
            else{
                count++;
            }
        }
        return max;
    }

}



//q4
public class Candy{
    public String getFlavor(){}
}

public class BoxOfCandy
{
    private Candy[][] box;
    // part-a
    public boolean moveCandyToFirstRow(int col){
        if(box[0][col]!=null){
            return true;
        }else{
            for(int i=1; i<box.size(); i++){
                if(box[i][col]!=null){
                    box[0][col] = box[i][col];
                    box[i][col] = null;
                }
            }
        }
        return false;
    }
    // part-b
    public Candy removeNextByFlavor(String flavor){
        int rowNum = box.length;
        for(int i=box.length-1; i>=0; i--){
            for(int j=0; j<box[i].length; j++){
                if(box[i][j].getFlavor().equals(flavor)){
                    Candy result = new Candy();
                    result = box[i][j];
                    box[i][j] = null;
                    return result;
                }
            }
        }
        return null;
    }

}


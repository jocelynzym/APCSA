//FRQ 2022
//新建array
//继承、父类方法和变量的调用
//new后面有()
//怎样取string的最后一个字符


//q1
public class Level
{
    public boolean goalReached()
    {}
    public int getPoints()
    {}
}

public class Game
{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;

    public Game(){}

    public boolean isBonus(){}

    public void play(){}

    //part(a)
    public int getScore()
    {
        int initScore = 0;
        if(levelOne.goalReached()){
            if(levelTwo.goalReached()){
                if(levelThree.goalReached()){
                    initScore = levelOne.getPoints()+levelTwo.getPoints()+levelThree.getPoints();
                }else{
                    initScore =  levelOne.getPoints()+levelTwo.getPoints();
                }
            }else{
                initScore = levelOne.getPoints();
            }
        }else{
            initScore = 0;
        }
        if(isBonus()) return initScore*3;
        else return initScore;
    }

    //part(b)
    public int playManyTimes(int num)
    {
        int maxScore = 0;
        for(int i=0; i<num; i++){
            play();
            int score = getScore();
            if (score>maxScore) maxScore = score;
        }
        return maxScore;
    }
}


//q2
public class Book{
    private String title;
    private double price;

    public Book(String bookTitle, double bookPrice){

    }
    public String getTitle(){
        return title;
    }
    public String getBookInfo(){
        return title + "-" + price
    }
}

public class TextBook extends Book{
    private int editionNum;

    public TextBook(String tbTitle, double tbPrice, int tbEdition){
        super(tbTitle,tbPrice);
        editionNum = tbEdition;
    }

    public int getEdition(){
        return editionNum;
    }

    public String getBookInfo(){
        return super.getBookInfo() + "-" + editionNum;
    }

    public boolean canSubstituteFor(TextBook targetBook){
        if(targetBook.getTitle().equals(getTitle()) && targetBook.getEdition()<=getEdition())
            return true;
        else 
            return false;
    }


}


//q3
public class Review{
    private int rating;
    private String comment;
    public Review(int r, String c){
        rating = r;
        comment = c;
    }
    public int getRating(){
        return rating;
    }
    public String getComment(){
        return comment;
    }
}

public class ReviewAnalysis
{
    private Review[] allReviews;
    public ReviewAnalysis(){}
    //part(a)
    public double getAverageRating(){
        int total = 0;
        for(int i=0; i<allReviews.length; i++){
            total += allReviews[i];
        }
        return total/allReviews.length;
    }
    //part(b)
    public ArrayList<String> collectComments(){
        ArrayList<String> allComments = new ArrayList<String>();

        for(int i=0; i<allReviews.length; i++)
        {
            if(allReviews[i].indexOf("!")>-1){
                String secondPart = allReviews[i].getComment();
                String lastChar = secondPart.substring(secondPart.length()-1);
                if(!lastChar.equals("!") && !lastChar.equals(".")){
                   secondPart +=  ".";
                }
                allComments.add(i +"-"+secondPart);
            } // end-if
        }// end-for
        return allComments;
    }
}



//q4
public class Data
{
    public static final int MAX = 1000;
    private int[][] grid;
    //part-a
    public void repopulate(){
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                int genValue = -1;
                while(true){
                    genValue =  int(Math.random() * MAX) + 1;
                    if((genValue%10 == 0) && (genValue%100 != 0)) 
                        break;
                }
                grid[row][col] = genValue;
            }
        }
    }
    //part-b
    public int countIncreasingCols(){
        int allQualified = 0;
        for(int col=0; col<gird[0].length; col++){
            boolean flag = true;
            for(int row=0; row<grid.length; row++){
                if(row>0 && grid[row][col]<grid[row-1][col]){
                    flag = false;
                    break;
                }
            }
            if(flag) allQualified++;
        }
        return allQualified;
    }
}


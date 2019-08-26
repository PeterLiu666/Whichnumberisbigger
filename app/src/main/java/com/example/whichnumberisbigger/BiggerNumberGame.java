package com.example.whichnumberisbigger;

public class BiggerNumberGame
{

    // Variables
    private int num1;
    private int num2;
    private int score = 0;
    private int lowerLimit;
    private int upperLimit;

    // Constructor
    public BiggerNumberGame(int lowerLimit, int upperLimit)
    {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        generateRandomNumber();
    }

    /* FUNCTION generateRandomNumber
     * Generate a number between the upper & lower limit inclusive
     * Store in num1
     * Generate another number and it's different from num1
     * Store in num2
     */
    public void generateRandomNumber()
    {

        // Generates random number
        num1 = (int)(Math.random() * (upperLimit - lowerLimit + 1)) + lowerLimit;
        num2 = (int)(Math.random() * (upperLimit - lowerLimit + 1)) + lowerLimit;

        // checks for equality
        while(num1 == num2)
        {
            num1 = (int)(Math.random() * (upperLimit - lowerLimit + 1)) + lowerLimit;
        }

        setNum1(num1);
        setNum2(num2);
    }

    /* FUNCTION checkAnswer
     * Determine if the answer is right
     * Update the score
     * Return a relevant message
     */
    public String checkAnswer(int answer)
    {
        if(num1 < num2)
        {
            if(answer == num2)
            {
                score++;
                return "Nice Job!!!";
            }
            else
            {
                score--;
                return "Wrong! Better luck next time!";
            }
        }
        else
        {
            if(answer == num1)
            {
                num1++;
                return "Nice Job!!!";
            }
            else
            {
                num1--;
                return "Wrong! Better luck next time!";
            }

        }
    }

    // Getter and Setter
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1)
    {
        this.num1 = num1;
    }

    public int getNum2()
    {
        return num2;
    }

    public void setNum2(int num2)
    {
        this.num2 = num2;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getLowerLimit()
    {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit)
    {
        this.lowerLimit = lowerLimit;
    }

    public int getUpperLimit()
    {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit)
    {
        this.upperLimit = upperLimit;
    }

}

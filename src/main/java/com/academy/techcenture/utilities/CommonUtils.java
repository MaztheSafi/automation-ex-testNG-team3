package com.academy.techcenture.utilities;



public class CommonUtils {
    private CommonUtils(){

    }


    /**
     * Generates a random number between min and max both inclusive
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max){

        return (int)(Math.random() * max) + min;
    }

    public static String generateRandomCreditCardNumber(){
        long ccNumber = (long)(Math.random()*10000000000000000l)+1;
        return String.valueOf(ccNumber);
    }
    public static String generateDate() {
        int randomYear = (int) (Math.random() * 98 + 1);
        int randomMonth = (int) (Math.random() * 11 + 1);
        String result = null;
        if (randomMonth < 10) {
            result = "0" + randomMonth + "/" + randomYear;
        }
        else{
            result = randomMonth + "/" + randomYear;
        }
        return result;
    }


}



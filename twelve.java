import java.util.*;


class Solution {
    static Dictionary<Integer, String> tensTable = new Hashtable<>();

    public String intToRoman(int num) {
        tensTable.put(0, "");
        tensTable.put(1, "I");
        tensTable.put(2, "II");
        tensTable.put(3, "III");
        tensTable.put(4, "IV");
        tensTable.put(5, "V");
        tensTable.put(6, "VI");
        tensTable.put(7, "VII");
        tensTable.put(8, "VIII");
        tensTable.put(9, "IX");

        String finalString = "";
        ArrayList<Integer> placesArray = new ArrayList<Integer>();
        while (true) {
            if (num == 0) {
                break;
            }
            int tempNum = num;
            int curPlaces = howManyPlaces(num);
            int divisor = exponentFunction(10, (curPlaces-1));
            tempNum = tempNum/divisor;
            num = num - (tempNum)*divisor;
            placesArray.add(tempNum*divisor);
            if (curPlaces == 1) {
                break;
            }
        }

        for (int i = 0; i < placesArray.size(); i++) {
            if (placesArray.get(i) >= 1000) {
                int tempNum = placesArray.get(i);
                while (true) {
                    tempNum -= 1000;
                    finalString += "M";
                    if (tempNum == 0) {
                        break;
                    }
                }
            }

            else if (placesArray.get(i) >= 100) {
                int tempNum = placesArray.get(i);
                if (tempNum >= 900) {
                    finalString += "CM";
                    tempNum -= 900;
                } else if (tempNum >= 500) {
                    finalString += "D";
                    tempNum -= 500;
                } else if (tempNum >= 400) {
                    finalString += "CD";
                    tempNum -= 400;
                } 

                while (true) {
                    if (tempNum <= 0) {
                        break;
                    }
                    tempNum -= 100;
                    finalString += "C";
                }
            }
            else if (placesArray.get(i) >= 10) {
                int tempNum = placesArray.get(i);
                if (tempNum >= 90) {
                    finalString += "XC";
                    tempNum -= 90;
                } else if (tempNum >= 50) {
                    finalString += "L";
                    tempNum -= 50;
                } else if (tempNum >= 40) {   
                    finalString += "XL";
                    tempNum -= 40;
                }

                while (true) {
                    if (tempNum <= 0) {
                        break;
                    }
                    tempNum -= 10;
                    finalString += "X";
                }
            } else {
                int tempNum = placesArray.get(i);
                finalString += tensTable.get(tempNum);
            }
        }




        return finalString;
    }

    public static int howManyPlaces(int num) {
        int length = 0;
        long temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }

    public static int exponentFunction(double base, double power) {
        int count = 1;
        while (power != 0) {
            count *= base;
            power--;
        }
        return count;
    }

}

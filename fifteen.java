import java.util.*;

//The final list will be the length of each string * each other. 234, each string is 3, 3*3*3 = 27.

class Fifteen {

    public static List<String> letterCombinations(String digits) {
        List<String> finalList = new ArrayList<>();
        HashMap<String, String> numLetters = new HashMap<>();
        numLetters.put("2", "abc");
        numLetters.put("3", "def");
        numLetters.put("4", "ghi");
        numLetters.put("5", "jkl");
        numLetters.put("6", "mno");
        numLetters.put("7", "pqrs");
        numLetters.put("8", "tuv");
        numLetters.put("9", "wxyz");

        ArrayList<String> currentLetters = new ArrayList<>();
        //charAt()

        //Zero digit case
        if (digits.length() == 0) {
            return finalList;
        }

        //One digit case
        if (digits.length() == 1) {
            String onlyNum = numLetters.get(digits);
            for (int i = 0; i < onlyNum.length(); i++) {
                String curChar = String.valueOf(numLetters.get(digits).charAt(i));
                finalList.add(curChar);
            }
            return finalList;
        }

        //Two digit case
        if (digits.length() == 2) {
            String strOne = numLetters.get(String.valueOf(digits.charAt(0)));
            String strTwo = numLetters.get(String.valueOf(digits.charAt(1)));
            for (int i = 0; i < strOne.length(); i++) {
                for (int j = 0; j < strTwo.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strOne.charAt(i)).append(strTwo.charAt(j));
                    String curString = sb.toString();
                    finalList.add(curString);
                }
            }
            return finalList;
        }

        //Three digit case
        if (digits.length() == 3) {
            String strOne = numLetters.get(String.valueOf(digits.charAt(0)));
            String strTwo = numLetters.get(String.valueOf(digits.charAt(1)));
            String strThree = numLetters.get(String.valueOf(digits.charAt(2)));
            for (int i = 0; i < strOne.length(); i++) {
                for (int j = 0; j < strTwo.length(); j++) {
                    for (int k = 0; k < strThree.length(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strOne.charAt(i)).append(strTwo.charAt(j)).append(strThree.charAt(k));
                        String curString = sb.toString();
                        finalList.add(curString);
                    }
                }
            }
            return finalList;
        }

        //Four digit case
        if (digits.length() == 4) {
            String strOne = numLetters.get(String.valueOf(digits.charAt(0)));
            String strTwo = numLetters.get(String.valueOf(digits.charAt(1)));
            String strThree = numLetters.get(String.valueOf(digits.charAt(2)));
            String strFour = numLetters.get(String.valueOf(digits.charAt(3)));
            for (int i = 0; i < strOne.length(); i++) {
                for (int j = 0; j < strTwo.length(); j++) {
                    for (int k = 0; k < strThree.length(); k++) {
                        for (int l = 0; l < strFour.length(); l++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(strOne.charAt(i)).append(strTwo.charAt(j)).append(strThree.charAt(k)).append(strFour.charAt(l));
                            String curString = sb.toString();
                            finalList.add(curString);
                        }
                    }
                }
            }
            return finalList;
        }


        return finalList;
    }

}


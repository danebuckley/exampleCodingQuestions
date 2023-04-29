class Seven {
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int parity = 0; //parity = 0 pos, parity = 1 neg
        int cur = 1;
        int count = 0;
        int prevCount = 0;
        if (x < 0) {
            parity = 1;
            x *= -1;
        }

        String temp = Integer.toString(x);
        int[] xArr = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            xArr[i] = temp.charAt(i) - '0';
        }

        for (int j = 0; j < xArr.length ; j++) {
            count += cur*xArr[j];
            if (prevCount != 0 && count%cur != prevCount) {
                return 0;
            }
            prevCount = count;
            cur *= 10;
        }

        if (parity == 1) {
            count *= -1;
            return count;
        } else {
            return count;
        }
    }
}
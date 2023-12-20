import java.util.*;

class GFG {

    // Function to print the fibonacci series
    static int fib(int n)
    {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return fib(n - 1) + fib(n - 2);
    }

    static void arrayToList(){
        Integer[] num = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> numbers = new ArrayList<Integer>(Arrays.<Integer>asList(num));

        String[] arr = {"a", "b", "c", "d", "z", "f"};
        List<String> arr2 = new ArrayList<String>(Arrays.<String>asList(arr));
    }

    public static int maxFrequency(int number){
        int[] array = new int[(number)+"".length()];
        int max = 0;
        while(number != 0){
            array[number%10] += 1;
            if(max < array[number%10]){
                max = array[number%10];
            }
            number = number/10;
        }
        return max;
    }

    // Driver Code
    public static void main(String args[]) {
        // Given Number N
        int[] A = {615, 88, 498, 99, 9};
        int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Integer num : A) {
            int digit = num % 10;
            digits[digit]++;
        }

        int max1 = 0;
        int max1d = 0;
        int max2 = 0;
        int max2d = 0;
        int i = 0;
        int score = 0;
        for (Integer num : digits) {
            if (num >= max1) {
                max2 = max1;
                max2d = max1d;
                max1 = num;
                max1d = i;
            }
            i++;
        }

        for(Integer num : digits){
            System.out.println(num);
        }

        for (Integer num : A) {
            String n = num + "";
            int com = 0;
            for (int a = 0; a < n.length(); a++) {
                char c1 = n.charAt(a);
                int c2 = Integer.parseInt(String.valueOf(c1));
                if(max1==max2){
                    if (c2 == max1d) {
                        com++;
                    }
                }else{
                    if (c2 == max1d) {
                        com++;
                    } else if (c2 == max2d) {
                        com++;
                    }
                }

            }
//            System.out.println("com = "+com);
//            System.out.println("len = "+n.length());
            if (com == n.length()) {
                score++;
            }
        }
//        System.out.println(score);
        System.out.println(max1);
        System.out.println(max1d);
        System.out.println(max2);
        System.out.println(max2d);

    }
}
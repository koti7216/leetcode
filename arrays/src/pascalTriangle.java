//there is also another approach for this problem by finding the coefficients of the binomial coefficients

import java.util.*;
public class pascalTriangle {
       /* public static List<List<Integer>> generate(int numRows) { // time complexity O(n^2) space complexity O(n)
            List<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>(); //it stores previous row
            ArrayList<Integer> third = new ArrayList<>(); // for 2nd row
            ArrayList<Integer> first = new ArrayList<>(); // for 1st row
            first.add(1);
            result.add(first);
            if(numRows == 1){
                return result;
            }
            third.add(1);
            third.add(1);
            result.add(third);
            int m = 0;
            second.add(1);
            second.add(1);
            for(int i = 2; i < numRows; i++){
                ArrayList<Integer> hii = new ArrayList<>();
                hii.add(1);
                for(int j = 1; j <= i - 1; j++){
                    m = second.get(j) + second.get(j - 1);
                    hii.add(m);
                }
                hii.add(1);
                second.clear();
                for(int h = 0; h < hii.size(); h++){
                    int k = hii.get(h);
                    second.add(k);
                }
                result.add(hii);

            }
            return result;
        }*/
    public static List<Integer> getRow(int rowIndex) { // time complexity O(n^2) space complexity O(n)
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(); // it stores previous row
        temp.add(1);
        temp.add(1);
        result.add(1);
        if(rowIndex == 0)
            return result;
        result.add(1);
        if(rowIndex == 1)
            return result;
        for(int i = 2; i <= rowIndex; i++){
            result.clear();
            result.add(1);
            for(int j = 1; j < i; j ++){
                result.add(temp.get(j - 1) + temp.get(j));
            }
            result.add(1);
            temp = new ArrayList<>(result);
        }
        return result;
    }

    public static void main(String[] args){
            System.out.print(getRow(4)); // it prints ArrayList of pascal triangle upto our input row for first code
        //prints row of the pascal triangle by running second code
        }
    }



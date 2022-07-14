import java.util.List;
import java.util.ArrayList;
public class spiralOrder {
        public static List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> koti = new ArrayList<>();
            int rmin = 0, rmax = matrix.length - 1, cmin = 0,cmax = matrix[0].length - 1;
            int i = rmin, j = cmin;
            while(koti.size() < matrix.length*matrix[0].length){

                for(j = cmin; j <= cmax; j++){
                    if(koti.size() < matrix.length*matrix[0].length){

                        koti.add(matrix[i][j]);
                    }
                }
                j--;
                for(i = rmin + 1; i <= rmax;i++){
                    if(koti.size() < matrix.length*matrix[0].length){

                        koti.add(matrix[i][j]);
                    }
                }
                i--;
                rmin = rmin + 1;
                for(j = cmax - 1; j >= cmin; j--){
                    if(koti.size() < matrix.length*matrix[0].length){

                        koti.add(matrix[i][j]);
                    }

                }
                j++;

                cmax = cmax - 1;
                for(i = rmax - 1; i >= rmin; i--){
                    if(koti.size() < matrix.length*matrix[0].length){

                        koti.add(matrix[i][j]);
                    }
                }
                i++;
                rmax = rmax - 1;
                cmin = cmin + 1;

            }
            return koti;
        }
        public static void main(String[] args){
            int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
            System.out.print(spiralOrder(matrix)); // it prints spiral order of the given matrix
        }
}

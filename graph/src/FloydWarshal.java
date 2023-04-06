//The problem is to find the shortest distances between every pair of vertices in a given edge-weighted
// directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j]
// denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
//Do it in-place.

public class FloydWarshal {
//User function template for JAVA
        public void shortest_distance(int[][] matrix)
        {
            // Code here
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    for(int k = 0; k < matrix.length; k++){
                        if(matrix[j][i]==-1 || matrix[i][k] == -1)
                            continue;
                        if(matrix[j][k] == -1)
                            matrix[j][k] = matrix[j][i]+matrix[i][k];
                        else{
                            matrix[j][k] = Math.min(matrix[j][k],matrix[j][i]+matrix[i][k]);
                        }
                    }
                }
            }
        }
}

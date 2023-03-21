public class RequestServer {
    public int ServerCount(int[] Server){
        int sum=0;
        int result=0;
        for(int i=0;i<Server.length;i++){
            sum+=Server[i];
            if(sum<0){
                result++;
                sum=0;
            }
        }
        return result;
    }
}

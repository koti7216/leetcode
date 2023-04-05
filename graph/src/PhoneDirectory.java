//Given a list of contacts contact[] of length n where each contact is a string which exist in a phone directory
// and a query string s. The task is to implement a search query for the phone directory.
// Run a search query for each prefix p of the query string s (i.e. from  index 1 to |s|)
// that prints all the distinct contacts which have the same prefix as p in lexicographical increasing order.
// Please refer the explanation part for better understanding.
//Note: If there is no match between query and contacts, print "0".
import java.util.*;
public class PhoneDirectory {


//User function Template for Java
        static ArrayList<ArrayList<String>> displayContacts(int n,
                                                            String contact[], String s)
        {
            // code here
            int t = 0;
            ArrayList<ArrayList<String>> a = new ArrayList<>();
            ArrayList<String> a2 = new ArrayList<>();
            HashSet<String> h = new HashSet<>();
            for(int i = 0; i < contact.length; i++){
                if(!h.contains(contact[i])){
                    a2.add(contact[i]);
                    h.add(contact[i]);
                }
            }
            for(int i =0; i < s.length(); i++){
                ArrayList<String> a1 = new ArrayList<>();
                for(int j = 0; j < a2.size(); j++){
                    if((a2.get(j).length() > i) && a2.get(j).charAt(i) == s.charAt(i))
                        a1.add(a2.get(j));
                }
                if(a1.size() == 0)
                    break;
                Collections.sort(a1);
                a.add(a1);
                a2 = new ArrayList<>(a1);
                t++;
            }
            while(t < s.length()){
                ArrayList<String> a1 = new ArrayList<>();
                a1.add("0");
                a.add(a1);
                t++;
            }
            return a;
        }
}

// "static void main" must be defined in a public class.
// 1.description:
// https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=f6f0e07423c645c78f888f3f7eca9745&pm=s
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r41

// 2. idea: sort + greedy
//    greedy: use max - min <=k in each group
      //把最大的加进来，加不进来就count++

public class Main {
    public static int PrimeMovieAward(int[] award, int k) {
        // sort
        Arrays.sort(award);
        int count = 1; // at leaset one group
        int curMin = award[0];
        for(int i = 0; i< award.length; i++){
            if(award[i]- curMin >k){ // if exceed, then start a new group from curMin.
                count++;
                curMin = award[i];
            }else{
                continue;
            }
        }
        return count;
        
    }
    
    public static void main(String[] args) {
        int[] test1 = {1,5,4,6,8,9,2};
        int k1 = 3;
        System.out.println(PrimeMovieAward(test1,k1));
    }
}


/*
// Time Complexity: O(nlog(n)) - Where n is the given movies array length since we need to first sort the entire given arrray and then loop through it to find the minimum numbers of group needed
    // Space Complexity: O(1) - Only constant space (result, currentMin) is used
*/

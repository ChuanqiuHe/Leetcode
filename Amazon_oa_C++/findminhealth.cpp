class Solution{
    public:
    int findMinHealth(vector<int> & vec, int armor){
        int maxvalue = INT_MIN;
        int sum;
        
        for(auto elem: vec){
            sum +=elem;
            if(elem >maxvalue){
                maxvalue = elem;
            }
        }
        return sum - min(maxvalue, armor) + 1;
    }
    
};

int main(){
    Solution s;
    
    vector<int> vec = {1,2,6,7};
    int armor = 5;
    int res = s.findMinHealth(vec, armor);
    
    cout << "res = "<< res <<endl;
    
    return 0;
}

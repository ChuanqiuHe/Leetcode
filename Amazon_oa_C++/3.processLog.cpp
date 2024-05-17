
//question: https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=1a68e608b6af41858e0fa154c1b857c7&pm=s

class Solution{
    public:
    vector<string> processLog(vector<string> & logs, int threshold ){
        
        map<string, int> id_count; //本身就是有序的
        
        for(auto &str : logs){
            // 使用stringstream来按空格分割字符串
            stringstream ss(str);
            string word;

            // 分割字符串并提取前两个单词
            ss>>word;
            string id1 = word;
            
            ss>>word;
            string id2 = word;
            
            if(id1!=id2){
                id_count[id1] ++;
                id_count[id2] ++;   
            }else{
                id_count[id1] ++;
            }  
            
        }
        
        // 存储结果的vector
        vector<string> result;

        // 将结果按照键（pair.first）的字典顺序排序并输出频率大于目标值的键值对
        for (const auto& pair : id_count) {
            if (pair.second > threshold) {
                // 将键值对按照指定格式存入结果vector中
                result.push_back(pair.first + " - " + to_string(pair.second));
            }
        }
        // 对结果vector按照键的字典顺序进行排序
        //sort(result.begin(), result.end());
        
        // 输出结果
        return result;
        
    }  
};

int main(){
    Solution s;
    
    vector<string> logs={
        "38239 345366 15",
        "029323 38239 77",
        "345366 38239 23",
        "029323 345366 13",
        "38239 38239 23",
        "345366 89921 45",
        "029323 38239 23"
             
    };
    
    vector<string> res = s.processLog(logs, 3);
    
    for(auto item: res){
        cout << item << endl;
    }
    return 0;
}


// 锻炼排序（1） 通过成员函数bool compare, (2) lambda方程式

class Solution{
    // public:
    // static bool Comp(const string& a, const string& b){
    //     return a>b;
    // } // 变成lambda
    public:
    vector<string> processLog(vector<string> & logs, int threshold ){
        
        map<string, int> id_count; //本身就是有序的
        
        for(auto &str : logs){
            // 使用stringstream来按空格分割字符串
            stringstream ss(str);
            string word;

            // 分割字符串并提取前两个单词
            ss>>word;
            string id1 = word;
            
            ss>>word;
            string id2 = word;
            
            if(id1!=id2){
                id_count[id1] ++;
                id_count[id2] ++;   
            }else{
                id_count[id1] ++;
            }  
            
        }
        
        // 存储结果的vector
        vector<string> result;

        // 将结果按照键（pair.first）的字典顺序排序并输出频率大于目标值的键值对
        for (const auto& pair : id_count) {
            if (pair.second > threshold) {
                // 将键值对按照指定格式存入结果vector中
                result.push_back(pair.first + " - " + to_string(pair.second));
            }
        }
        // 对结果vector按照键的字典顺序进行排序
        //sort(result.begin(), result.end(), Comp);
        
        // 使用lambda表达式进行反向排序
        // sort(result.begin(), result.end(), [](const string& a, const string& b){
        //     return a>b;
        // });
        
        // 输出结果
        return result;
        
    }  
};


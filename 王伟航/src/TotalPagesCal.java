/*
计算总页数
 */
public class TotalPagesCal {
    public int calculateTP(int pageSize,int totalRecord){
        int totalPages;
        if(totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }
        return totalPages;
    }
}

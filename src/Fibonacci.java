import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Fibonacci {
    public int solution(int num){
        if(num > 20 || num < 0) return -1; //20 보다 큰 수나 0보다 작은 수가 들어오면
        return fibo(num);
    }
    public int fibo(int num) {
        if(num == 0) return 0;          //0일때는 0
        else if (num == 1) return 1;    //1일때는 1
        else {
            return fibo(num-1) + fibo(num-2);
        }
    }
}
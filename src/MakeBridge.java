import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MakeBridge {
    public long[] solution(int num, int[][] commands) {
        long[] result = new long[num];
        for(int i = 0; i < commands.length; i++) {
            int n = commands[i][0];
            int m = commands[i][1];
            result[i] = combi(m,n);
        }
        return result;
    }

    public long combi(int m,int n) {
        long result = 1;
        for(int i = 1; i<=n;i++) {
            result = result*(m -i +1) / (i) ;
        }
        return result;
    }

    @Test
    void test() {
        MakeBridge bridge = new MakeBridge();
        int input1 = 3;
        int[][] input2  = {{2,2},{1,5},{13,29}};
        long[] result = {1,5,67863915};
        assertArrayEquals(result,bridge.solution(input1,input2));
    }
}

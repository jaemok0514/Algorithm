import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void solution() {
        Fibonacci sol = new Fibonacci();
        int input1 = 11;
        int result = 89;

        assertEquals(result,sol.solution(input1));
    }
}
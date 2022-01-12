import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @Test
    void isAnagram() {
        Valid sol = new Valid();
        String input1 = "anagram";
        String input2 = "nagaram";

        assertEquals(true,sol.isAnagram(input1,input2));

        String input3 = "rat";
        String input4 = "car";

        assertEquals(false,sol.isAnagram(input3,input4));

        String input5 = "asdfgggg";
        String input6 = "asdf";

        assertEquals(false,sol.isAnagram(input5,input6));

    }
}
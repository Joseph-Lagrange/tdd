import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MommifierTest {

    @Test
    void should_return_original_string_when_calculate_vowels_are_less_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String result = mommifier.calculate("girl");
        assertEquals("girl", result);
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MommifierTest {

    @Test
    void should_return_original_string_when_convert_vowels_are_less_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String result = mommifier.convert("girl");
        assertEquals("girl", result);
    }

    @Test
    void should_return_inserted_string_when_convert_vowels_are_more_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String result = mommifier.convert("giilii");
        assertEquals("gimommyilimommyi", result);
    }
}

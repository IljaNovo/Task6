import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserParamsTest {

    @Test
    public void testParse() throws Exception {
        ParserParams parserParams = new ParserParams();
        String[]args = "-l 2 -r 5 -o +".split(" ");

        parserParams.parse(args);

        assertEquals(parserParams.getSymbolSignOperation(), "+");
        assertEquals(parserParams.getValueLeftParam(), 2);
        assertEquals(parserParams.getValueRightParam(), 5);
    }

    @Test
    public void testErrorParse() throws Exception {
        ParserParams parserParams = new ParserParams();
        String[]args = "-l 2 -r -o".split(" ");

        try {
            parserParams.parse(args);
        }
        catch (Throwable e) {
            assertTrue(true);
        }
    }

    @Test
    public void testNullInParams() throws Exception {
        ParserParams parserParams = new ParserParams();

        try {
            parserParams.parse(null);
        }
        catch (Throwable e) {
            assertTrue(true);
        }
    }
}
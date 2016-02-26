import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestSaveLoad extends Assert{

    @Test
    public void testReflection() throws FileNotFoundException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {
        String fileName = "AllCases.txt";
        AllCases allCases = new AllCases();
        ReflectionTest.saveClass(fileName, allCases);
        assertEquals(allCases, ReflectionTest.loadClass(fileName));
    }


}

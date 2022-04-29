
import org.junit.jupiter.api.*;

public class ClassOfFunctionsTest {
    ClassOfFunctions classOfFunctions;
    String expected;

    @BeforeEach
    public void init(){
    classOfFunctions = new ClassOfFunctions();
    }

    @Nested
    public class CheckEvenTest {
        @BeforeEach
       public void init (){
           expected = "Even";
       }

        @Test
        public void check4IsEven() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(4));
        }
        @Test
        public void check6IsEven() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(4));
        }

        @Test
        public void check0IsEven() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(0));
        }
        @Test
        public void checkNeg10IsEven() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(-10));
        }@Test
        public void checkNeg20IsEven() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(-20));
        }
        @AfterEach
        public void clear(){
            classOfFunctions = null;
        }
    }

    @Nested
    public class CheckOddTest {
        @BeforeEach
        public void init (){
            expected = "Odd";
        }

        @Test
        public void check5IsOdd() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(5));
        }
        @Test
        public void check7IsOdd() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(7));
        }
        @Test
        public void checkNeg29IsOdd() {
            Assertions.assertEquals(expected, classOfFunctions.checkEvenOrOdd(-29));
        }
        @AfterEach
        public void clear(){
            classOfFunctions = null;
        }
    }

    @Nested
    public class MaximumTest{
        @Test
        public void testCase1(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, -2, 4}, 5);
            Assertions.assertEquals(4, classOfFunctions.findMax());
        }

        @Test
        public void testCase2(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, -2, 4, -20, 7}, 7);
            Assertions.assertEquals(7, classOfFunctions.findMax());
        }

        @Test
        public void testCase3(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, 5}, 4);
            Assertions.assertEquals(5, classOfFunctions.findMax());
        }
        @Test
        public void testCase4(){
            classOfFunctions.initializeArray(new double[]{-1,-2,-7,-3,-30}, 5);
            Assertions.assertEquals(-1, classOfFunctions.findMax());
        }

        @AfterEach
        public void clear(){
            classOfFunctions = null;
        }
    }

    @Nested
    public class MinimumTest{
        @Test
        public void testCase1(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, -2, 4}, 5);
            Assertions.assertEquals(-2, classOfFunctions.findMin());
        }

        @Test
        public void testCase2(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, -2, 4, -20, 7}, 7);
            Assertions.assertEquals(-20, classOfFunctions.findMin());
        }

        @Test
        public void testCase3(){
            classOfFunctions.initializeArray(new double[]{1, 2, 3, 5}, 4);
            Assertions.assertEquals(1, classOfFunctions.findMin());
        }
        @Test
        public void testCase4(){
            classOfFunctions.initializeArray(new double[]{-1,-2,-7,-3,-30}, 5);
            Assertions.assertEquals(-30, classOfFunctions.findMin());
        }

        @AfterEach
        public void clear(){
            classOfFunctions = null;
        }
    }



    @AfterEach
    public void clear(){
        classOfFunctions = null;
    }
}


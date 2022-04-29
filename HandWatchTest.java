
import org.junit.jupiter.api.*;
public class HandWatchTest {

    HandWatch handWatch;

    @BeforeEach
    public void init (){
    handWatch = new HandWatch();
    }


    // edge coverage test suite
    @Nested
    public class EdgeCoverageTest {

        @Nested
        public class NormalModeEdgesTest {
            @Test
            public void tesCase1() {    // NORMAL-TIME to NORMAL-DATE
                handWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-DATE", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase2() {// NORMAL-DATE to NORMAL-TIME
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-TIME", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase3() { // NORMAL-TIME to ALARM-ALARM
                handWatch.pressButton('b');
                Assertions.assertEquals("ALARM-ALARM", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }


            @Test
            public void tesCase4() { // NORMAL-TIME to UPDATE-MIN
                handWatch.pressButton('c');
                Assertions.assertEquals("UPDATE-MIN", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                handWatch = null;
            }

        }



        @Nested
        public class AlarmModeEdgesTest {
            @Test
            public void tesCase1() {    // NORMAL-TIME to NORMAL-DATE
                handWatch.pressButton('b');
                handWatch.pressButton('a');
                Assertions.assertEquals("ALARM-CHIME", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase2() {// NORMAL-DATE to NORMAL-TIME
                handWatch.pressButton('b');
                handWatch.pressButton('d');
                Assertions.assertEquals("NORMAL-TIME", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                handWatch = null;
            }

        }


        @Nested
        public class UpdateModeEdgesTest {
            @Test
            public void tesCase1() {    // UPDATE-MIN to UPDATE-HOUR
                handWatch.pressButton('c');
                handWatch.pressButton('a');

                Assertions.assertEquals("UPDATE-HOUR", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase2() { // UPDATE-HOUR to UPDATE-DAY
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-DAY", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase3() { // UPDATE-DAY to UPDATE-MONTH
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-MONTH", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }


            @Test
            public void tesCase4() {// UPDATE-MONTH to UPDATE-YEAR
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-YEAR", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }


            @Test
            public void tesCase5() { // UPDATE-YEAR to NORMAL-DATE
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-TIME", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase6() {    // UPDATE to NORMAL-DATE
                handWatch.pressButton('c');
                handWatch.pressButton('d');
                Assertions.assertEquals("NORMAL-TIME", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @Test
            public void tesCase7() {    // UPDATE-MIN
                handWatch.pressButton('c');
                handWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-MIN", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:1", handWatch.displayTime());
            }

            @Test
            public void tesCase8() { // UPDATE-HOUR
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-HOUR", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", handWatch.displayDate());
                Assertions.assertEquals("1:0", handWatch.displayTime());
            }

            @Test
            public void tesCase9() { // UPDATE-DAY
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-DAY", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-2", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }


            @Test
            public void tesCase10() {// UPDATE-MONTH
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-MONTH", handWatch.displayCurrentState());
                Assertions.assertEquals("2000-2-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }


            @Test
            public void tesCase11() { // UPDATE-YEAR
                handWatch.pressButton('c');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('a');
                handWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-YEAR", handWatch.displayCurrentState());
                Assertions.assertEquals("2001-1-1", handWatch.displayDate());
                Assertions.assertEquals("0:0", handWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                handWatch = null;
            }

        }
    }

    @Nested
    public class ADUTesting {

        @Test
        public void tesCase1() {    // UPDATE-MIN
            handWatch.pressButton('c');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-MIN", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-1", handWatch.displayDate());
            Assertions.assertEquals("0:1", handWatch.displayTime());
        }

        @Test
        public void tesCase2() { // UPDATE-HOUR
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-HOUR", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-1", handWatch.displayDate());
            Assertions.assertEquals("1:0", handWatch.displayTime());
        }

        @Test
        public void tesCase3() { // UPDATE-DAY
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-DAY", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-2", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }


        @Test
        public void tesCase4() {// UPDATE-MONTH
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-MONTH", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-2-1", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }


        @Test
        public void tesCase5() { // UPDATE-YEAR
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-YEAR", handWatch.displayCurrentState());
            Assertions.assertEquals("2001-1-1", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }



        @Test
        public void tesCase6() {    // UPDATE-MIN
            handWatch.pressButton('c');
            handWatch.pressButton('b');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-MIN", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-1", handWatch.displayDate());
            Assertions.assertEquals("0:2", handWatch.displayTime());
        }

        @Test
        public void tesCase7() { // UPDATE-HOUR
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-HOUR", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-1", handWatch.displayDate());
            Assertions.assertEquals("2:0", handWatch.displayTime());
        }

        @Test
        public void tesCase8() { // UPDATE-DAY
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-DAY", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-3", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }


        @Test
        public void tesCase9() {// UPDATE-MONTH
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-MONTH", handWatch.displayCurrentState());
            Assertions.assertEquals("2000-3-1", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }


        @Test
        public void tesCase10() { // UPDATE-YEAR
            handWatch.pressButton('c');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('a');
            handWatch.pressButton('b');
            handWatch.pressButton('b');
            Assertions.assertEquals("UPDATE-YEAR", handWatch.displayCurrentState());
            Assertions.assertEquals("2002-1-1", handWatch.displayDate());
            Assertions.assertEquals("0:0", handWatch.displayTime());
        }


        @AfterEach
        public void clear() {
            handWatch = null;
        }

    }

        @AfterEach
        public void clear(){
            handWatch = null;
        }


    }
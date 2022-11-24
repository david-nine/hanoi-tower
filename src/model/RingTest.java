package model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RingTest {

    @Nested
    static class GetRawTest {

        @Test
        void raw() {
            Ring ring1 = new Ring((short) 1);
            Ring ring2 = new Ring((short) 2);
            Ring ring3 = new Ring((short) 3);

            System.out.println(ring1.getRaw((short) 3));
            System.out.println(ring2.getRaw((short) 3));
            System.out.println(ring3.getRaw((short) 3));
        }

    }

}
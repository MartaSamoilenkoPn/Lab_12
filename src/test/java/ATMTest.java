import task1.ATM;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ATMTest {

    @Test
    public void testATMProcess() {
        ATM atm = new ATM();
        atm.process(600);
        assertEquals(20, atm.firstTray.getDenominationCount(5));
        assertEquals(0, atm.firstTray.getDenominationCount(200));
        assertEquals(1, atm.firstTray.getDenominationCount(500));
    }
}

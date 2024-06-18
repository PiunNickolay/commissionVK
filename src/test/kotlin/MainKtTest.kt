import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commission() {
        val cardType:String = "Mastercard"
        val previousTransfersThisMonth = 0
        val transferAmount = 50000

        val result = commission(cardType, previousTransfersThisMonth, transferAmount)

        assertEquals(320, result)
    }
}

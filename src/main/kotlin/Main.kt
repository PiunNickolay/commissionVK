fun main() {
    val cardType:String = "Maestro"
    val previousTransfersThisMonth = 0
    val transferAmount = 80000

    val result = commission("Maestro", 0, 150_000)
    if(result!=null){
        println("Сумма перевода: $transferAmount руб.")
        println("Комиссия: $result руб.")
    }else{
        println("Операция блокирована из-за превышения лимита.")
    }
}

fun commission(cardType: String, previousTransfersThisMonth:Int, transferAmount:Int): Int?{
    val dailyLimit: Int = 150_000
    val monthlyLimit:Int = 600_000
    val vkDailyLimit: Int = 15_000
    val vkMonthLimit: Int = 40_000

    val commission = when(cardType){
        "Mastercard", "Maestro" -> {
            if(dailyLimit<transferAmount || monthlyLimit<previousTransfersThisMonth+transferAmount){
                return null
            }else if(300<=previousTransfersThisMonth && previousTransfersThisMonth<=75_000){
                return 0
            }else{
                return (transferAmount*0.006+20).toInt()
            }
        }
        "Visa", "Мир"-> {
            val commission = (transferAmount * 0.0075).toInt()
            if(dailyLimit<transferAmount || monthlyLimit<previousTransfersThisMonth+transferAmount){
                return 0
            }else if(commission<35){
                return 35
            }else{
                return commission
            }
        }
        "VKPay"->{
            if(vkDailyLimit<transferAmount || vkMonthLimit< transferAmount+previousTransfersThisMonth){
                return null
            }else{
                0
            }
        }
        else->0
    }
    return commission
}

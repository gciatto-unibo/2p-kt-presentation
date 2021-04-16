val i = Integer.of(1)

val iValue: BigInteger = i.value // BigInteger.of(1)
val iIntValue: BigInteger = i.intValue // BigInteger.of(1)
val iDecValue: BigDecimal = i.decimalValue // BigDecimal.of(1.0)

val iInt: Int = i.value.toInt() // 1
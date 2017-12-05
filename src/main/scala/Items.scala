sealed trait Item {
  val price: BigDecimal
}

case class Apple(price: BigDecimal = 0.60) extends Item

case class Orange(price: BigDecimal = 0.25) extends Item
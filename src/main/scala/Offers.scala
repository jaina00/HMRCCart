sealed trait Offers {
  def calculatePrice(items: Seq[Item]): BigDecimal
}

object NoOffer extends Offers {
  override def calculatePrice(items: Seq[Item]): BigDecimal = {
    items.map(_.price).sum
  }
}

object SimpleOffer extends Offers {
  override def calculatePrice(items: Seq[Item]): BigDecimal = {
    val group = items.groupBy(identity).mapValues(_.size)

    val applyOffer: Map[Item, Int] = group.map(x => {
      x._1 match {
        case a: Apple => (a, x._2 / 2 + x._2 % 2)
        case b: Orange => (b, (2 * x._2 / 3) + x._2 % 3)
      }
    })

    applyOffer.foldLeft(BigDecimal(0)) { (acc, ele) => acc + (ele._1.price * ele._2) }
  }
}
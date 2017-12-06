object ShoppingCart {

  def calculateTotal(items: Seq[Item]): BigDecimal = {
    selectOffer(items).calculateOffer(items)
  }

  def selectOffer(items: Seq[Item]): Offers = {
    val noOfApples = items.collect { case a: Apple => a }.size
    val noOfOranges = items.collect { case a: Orange => a }.size

    (noOfApples, noOfOranges) match {
      case _ if noOfApples > 1 || noOfOranges > 2 => SimpleOffer
      case _ => NoOffer
    }
  }

}
object ShoppingCart {
  def calculateTotal(items: List[Item]): BigDecimal = {
    items.map(_.price).sum
  }
}
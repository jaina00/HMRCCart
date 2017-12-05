import org.scalatest.FlatSpec

class ShoppingCartTest extends FlatSpec {

  behavior of "Cart"

  it should "calculate price for the items present" in {
    val total = ShoppingCart.calculateTotal(List(Apple(), Apple(), Orange(), Apple()))
    assert(total === 2.05)
  }
}
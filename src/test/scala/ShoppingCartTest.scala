import org.scalatest.FlatSpec

class ShoppingCartTest extends FlatSpec {

  behavior of "ShoppingCart#calculateTotal"

  it should "calculate price for the items present" in {
    val total = ShoppingCart.calculateTotal(List(Apple(), Orange(), Orange()))
    assert(total === 1.10)
  }

  it should "calculate price for the items with offers" in {
    val total = ShoppingCart.calculateTotal(List(Apple(), Apple(), Apple(),
      Orange(), Orange(), Orange(), Orange()))
    assert(total === 1.95)
  }

  behavior of "ShoppingCart#selectOffer"

  it should "select correct offer for NoOffer case" in {
    val offer = ShoppingCart.selectOffer(List(Apple(), Orange(), Orange()))
    assert(offer === NoOffer)
  }

  it should "select correct offer for SimpleOffer case" in {
    val offer = ShoppingCart.selectOffer(List(Apple(), Apple(), Apple(),
      Orange(), Orange(), Orange(), Orange()))
    assert(offer === SimpleOffer)
  }

}
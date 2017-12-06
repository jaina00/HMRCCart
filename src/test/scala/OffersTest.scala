import org.scalatest.FlatSpec

class OffersTest extends FlatSpec {

  behavior of "NoOffer"

  it should "calculate on items" in {
    val total = NoOffer.calculatePrice(List(Apple(), Apple(), Apple(), Orange()))
    assert(total === 2.05)
  }

  it should "calculate on Oranges" in {
    val total = SimpleOffer.calculatePrice(List(Orange(), Orange(), Orange()))
    assert(total === 0.50)
  }

  it should "calculate on Apples and oranges" in {
    val total = SimpleOffer.calculatePrice(List(Apple(), Apple(), Apple(),
      Orange(), Orange(), Orange(), Orange()))
    assert(total === 1.95)
  }

  behavior of "SimpleOffer"

  it should "calculate on Apples" in {
    val total = SimpleOffer.calculatePrice(List(Apple(), Apple()))
    assert(total === 0.60)
  }

  it should "calculate on Oranges" in {
    val total = SimpleOffer.calculatePrice(List(Orange(), Orange(), Orange()))
    assert(total === 0.50)
  }

  it should "calculate on Apples and oranges" in {
    val total = SimpleOffer.calculatePrice(List(Apple(), Apple(), Apple(),
      Orange(), Orange(), Orange(), Orange()))
    assert(total === 1.95)
  }


}

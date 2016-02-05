

object Driver {
  def main(args: Array[String]) : Unit = {

    additionTest()
    println()

    nestedAdditionTest()
    println()

    nestedMultiplicationTest()
    println()

    lessThanTestOne()
    println()

    lessThanTestTwo()
    println()
  }

  def additionTest() = {
    val e = new Add (
      new SimpleInteger(5),
      new SimpleInteger(7)
    )

    (new Machine(e)).run
  }

  def nestedAdditionTest() = {
    val e = new Add (
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    (new Machine(e)).run
  }

  def nestedMultiplicationTest() = {
    val e = new Multiply(
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    (new Machine(e)).run
  }

  def lessThanTestOne() = {
    val left = new Multiply(
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    val right = new Multiply(new SimpleInteger(10), new SimpleInteger(6))

    val e = new LessThan(left, right)

    (new Machine(e)).run

  }

  def lessThanTestTwo() = {
    val left = new Multiply(
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    val right = new Multiply(new SimpleInteger(10), new SimpleInteger(6))

    val e = new LessThan(right, left)

    (new Machine(e)).run

  }


}
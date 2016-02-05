

object Driver {
  def main(args: Array[String]) : Unit = {


    additionTest()
    println()
    nestedAdditionTest()
    println()
    nestedMultiplicationTest()

  }

  def additionTest() = {
    val e = new Add (
      new SimpleNumber(5),
      new SimpleNumber(7)
    )

    (new Machine(e)).run
  }

  def nestedAdditionTest() = {
    val e = new Add (
      new SimpleNumber(5),
      new Add (
        new SimpleNumber(4),
        new SimpleNumber(13)
      )
    )

    (new Machine(e)).run
  }

  def nestedMultiplicationTest() = {
    val e = new Multiply(
      new SimpleNumber(5),
      new Add (
        new SimpleNumber(4),
        new SimpleNumber(13)
      )
    )

    (new Machine(e)).run
  }

}
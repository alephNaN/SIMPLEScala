

object Driver {
    def main(args: Array[String]) : Unit = {
     // additionTest()
      nestedAdditionTest()

    }

    def additionTest() = {
      val e = new Add (
        new SimpleNumber(5),
        new SimpleNumber(7)
      )

      println("e:" + e)
      println("reducible?: "+ e.isReducible)
      println("reduce: " + e.reduce)

      // Expressions are immutable, should be unchanged
      println("e: " +  e)
      println("reducible?: " + e.isReducible)
      println("reduce: " + e.reduce)

      val e2 = e.reduce
      println("e2:" + e2)
      println("reducible?: "  + e2.isReducible)
    }

  def nestedAdditionTest() = {
    val e = new Add (
      new SimpleNumber(5),
      new Add (
        new SimpleNumber(4),
        new SimpleNumber(13)
      )
    )

    println("e:" + e)
    println("reducible?: "+ e.isReducible)
    println("reduce: " + e.reduce)

    val e2 = e.reduce
    println("e2:" + e2)
    println("reducible?: "  + e2.isReducible)

    val e3 = e2.reduce
    println("e3:" + e3)
    println("reducible?: "  + e3.isReducible)
  }



}
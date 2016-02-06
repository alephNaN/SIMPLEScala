import EnvironmentType.Environment

import scala.collection.immutable.HashMap

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

    variableTest()
    println()
  }

  def additionTest() = {
    val expr = new Add (
      new SimpleInteger(5),
      new SimpleInteger(7)
    )

    val env : Environment = Map()

    (new Machine(expr, env)).run
  }

  def nestedAdditionTest() = {
    val expr = new Add (
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    val env : Environment = Map()

    (new Machine(expr, env)).run
  }

  def nestedMultiplicationTest() = {
    val expr = new Multiply(
      new SimpleInteger(5),
      new Add (
        new SimpleInteger(4),
        new SimpleInteger(13)
      )
    )

    val env : Environment = Map()

    (new Machine(expr, env)).run
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

    val expr = new LessThan(left, right)

    val env : Environment = Map()

    (new Machine(expr, env)).run

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

    val expr = new LessThan(right, left)

    val env : Environment = Map()

    (new Machine(expr, env)).run

  }

  def variableTest() = {
    val expr =  new Add(
      new Variable('x),
      new SimpleInteger(3)
    )
    val env: Environment = Map('x -> new SimpleInteger(2))

    new Machine(expr, env).run
  }


}
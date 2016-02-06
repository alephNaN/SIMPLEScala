import EnvironmentType.Environment

import scala.collection.immutable.HashMap

object Driver {
  def main(args: Array[String]) : Unit = {

    assignmentTest()
    println()

    ifTest()
    println()
  }


  def assignmentTest() = {

      val statement = new Assign('x, new Add(new Variable('x), new SimpleInteger(5)))
      val env: Environment = Map('x -> new SimpleInteger(2))

      val m = new Machine(statement, env)
      m.run()

  }

  def ifTest() = {

      val statement = new If(
        new LessThan(
          new Variable('x),
          new SimpleInteger(7)
        ),
        new Assign(
          'y,
          new SimpleInteger(100)
        ),
        new Assign(
          'y,
          new SimpleInteger(200)
        )
      )

      val environment : Environment = Map('x -> new SimpleInteger(6))

      val m = new Machine(statement, environment)

      m.run()

  }

}
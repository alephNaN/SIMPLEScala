import EnvironmentType.Environment

import scala.collection.immutable.HashMap

object Driver {
  def main(args: Array[String]) : Unit = {


    assignmentTest()
    println()
  }


  def assignmentTest() = {

      val statement = new Assign('x, new Add(new Variable('x), new SimpleInteger(5)))
      val env: Environment = Map('x -> new SimpleInteger(2))

      val m = new Machine(statement, env)
      m.run()

  }


}
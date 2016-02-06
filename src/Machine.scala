import EnvironmentType.Environment


// Abstract Machine to Single Step reduce expression
class Machine(statement: Statement, environment: Environment) {

  var currStatement = statement
  var currEnvironment = environment

  def step() = {
    val pre = this.currStatement

    val (nextStatement, nextEnvironment) = this.currStatement.reduce(this.currEnvironment)

    currStatement = nextStatement
    currEnvironment = nextEnvironment
    
    println("Reduce: " + pre + " -> " + this.currStatement)
  }

  def run() : Unit = {

    while (currStatement.isReducible ) {
      println("Statement: " + this.currStatement + ", Environment: " + this.currEnvironment)

      this.step()
    }

    println("Final Statement: " + this.currStatement + ", Environment: " + this.currEnvironment)


  }

}

object EnvironmentType {
  type Environment = Map[Symbol, Primitive]
}
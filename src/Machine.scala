import EnvironmentType.Environment


// Abstract Machine to Single Step reduce expression
class Machine(_expression: Expression, environment: Environment) {

  var expression = _expression

  def step() = {
    val pre = this.expression

    this.expression = this.expression.reduce(environment)

    println("Reduce: " + pre + " -> " + this.expression)
  }

  def run() : Unit = {
    println("Initial Expression: " + this.expression)
    while (expression.isReducible ) {
      this.step()

    }

    println("Final Reduced Expression: " + this.expression)

  }

}

object EnvironmentType {
  type Environment = Map[Symbol, Primitive]
}
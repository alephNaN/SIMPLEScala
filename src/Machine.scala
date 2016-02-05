// Abstract Machine to Single Step reduce expression
class Machine(_expression: Expression) {

  var expression = _expression

  def step() = {
    val pre = this.expression
    this.expression = this.expression.reduce

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

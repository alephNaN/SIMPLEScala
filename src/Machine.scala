// Abstract Machine to Single Step reduce expression
class Machine(_expression: Expression) {

  var expression = _expression

  def step() = {
    val pre = this.expression
    this.expression = this.expression.reduce

    println("Reduced: [" + pre + "] -> " + "[" + this.expression + "]")
  }

  def run() : Unit = {
    println("Expression: " + this.expression)
    while (expression.isReducible ) {
      println("Expression is reducible. ")
      this.step()

    }

    println("Reduced Expression: " + this.expression)

  }

}

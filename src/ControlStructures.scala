import EnvironmentType.Environment

trait ControlStructure extends Statement {

}

class If(condition: Expression, consequence: Statement, alternative: Statement) extends ControlStructure {

  override def toString(): String = {
    "if (" + condition + ") { " + consequence + " } else { " + alternative + " }"
  }

  def isReducible = { true }

  def reduce(env: Environment) : Tuple2[Statement, Environment] = {
    if ( condition.isReducible) {
      (new If(condition.reduce(env), consequence, alternative), env)
    } else {
      if (condition == new SimpleBoolean(true)) {
        (consequence, env)
      } else {
        (alternative, env)
      }
    }


  }

}

class While(condition: Expression, body: Statement) extends ControlStructure {

  override def toString() : String = {
    "while(" + condition + " ) { " + body + " }"
  }

  def isReducible = { true }

  def reduce(env: Environment): Tuple2[Statement, Environment] = {
    val reducedStatement = (
      new If(
        condition,
        new Sequence(body, this),
        new Noop
      ))

    (reducedStatement, env)

  }

}
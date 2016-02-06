import EnvironmentType.Environment

trait Expression {

  def isReducible() : Boolean

  def reduce(env: Environment) : Expression

}

trait Primitive extends Expression {

  val value : Any

}
import EnvironmentType.Environment

case class Variable(name: Symbol) extends Expression {

  override def toString() = { name.toString }

  def isReducible() = { true }

  def reduce(env: Environment) = { env(name) }

}

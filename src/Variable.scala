import EnvironmentType.Environment

class Variable(_name: Symbol) extends Expression {
  val name = _name

  override def toString() = { name.toString }

  def isReducible() = { true }

  def reduce(env: Environment) = { env(name) }

}

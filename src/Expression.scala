import EnvironmentType.Environment

trait Operatable {
  def isReducible(): Boolean
}

trait Expression extends Operatable{

  def reduce(env: Environment) : Expression

}

trait Primitive extends Expression {

  val value : Any

}

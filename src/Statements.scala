import EnvironmentType._

trait Statement extends Operatable {
  def reduce(env: Environment) : Tuple2[Statement, Environment]
}

class Noop extends Statement {
  override def toString() = { "Noop;" }

  def isReducible() = { false }

  def reduce(env: Environment) = { (this, env) }

}

class Assign(name: Symbol, expr: Expression) extends Statement {

  override def toString() = { name + " = " + expr }

  def isReducible() = { true }

  def reduce(env: Environment) : Tuple2[Statement, EnvironmentType.Environment] =  {
    expr.isReducible match {
      case true =>
        (new Assign( name , expr.reduce(env)), env)
      case _ =>
        val envUpdate = (name -> expr)
        val updatedEnv : Environment = (env + envUpdate).asInstanceOf[Environment]
        (new Noop(), updatedEnv )
    }

  }

}


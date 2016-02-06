import EnvironmentType.Environment

// Represents a Integer type in Simple
case class SimpleInteger(_value : Int) extends Primitive {

  val value = _value

  def isReducible() : Boolean = false

  override def toString(): String = { value.toString }

  // irreducible reduces to itself, leaving environment unchanged
  def reduce(env: Environment) : Expression = this

}

// Represents a boolean type in SIMPLE
case class SimpleBoolean(_value : Boolean) extends Primitive {

  val value = _value

  def isReducible() : Boolean = false

  override def toString(): String = { value.toString }

  // irreducible reduces to itself, leaving environment unchanged
  def reduce(env: Environment) : Expression = this

}
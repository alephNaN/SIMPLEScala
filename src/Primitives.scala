// Represents a Integer type in Simple
class SimpleInteger(_value : Int) extends Primitive {

  val value = _value

  def isReducible() : Boolean = false

  override def toString(): String = { value.toString }

  // irreducible reduces to itself
  def reduce() : Expression = this

}

// Represents a boolean type in SIMPLE
class SimpleBoolean(_value : Boolean) extends Primitive {

  val value = _value

  def isReducible() : Boolean = false

  override def toString(): String = { value.toString }

  // irreducible reduces to itself
  def reduce() : Expression = this

}
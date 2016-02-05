class SimpleNumber(_value : Number) extends Primitive {

  val value = _value

  def isReducible() : Boolean = false

  override def toString(): String = { value.toString }

  // irreducible reduces to itself
  def reduce() : Expression = this

}

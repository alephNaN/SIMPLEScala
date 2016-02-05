trait Expression {

  def isReducible() : Boolean

  def reduce() : Expression

}

trait Primitive extends Expression {

  val value : Any

}
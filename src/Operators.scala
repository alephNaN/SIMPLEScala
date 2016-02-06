import EnvironmentType.Environment

class Add(left : Expression, right: Expression) extends Expression {

  override def toString() = "(" + left + "+" + right + ")"

  def isReducible(): Boolean = { true }

  def reduce(env: Environment) : Expression  = {
    (left.isReducible, right.isReducible) match {
      case (true, _) => new Add( left.reduce(env) , right )
      case (_, true) => new Add( left , right.reduce(env) )
      case _ => new SimpleInteger(left.asInstanceOf[Primitive].value.asInstanceOf[Int].+(right.asInstanceOf[Primitive].value.asInstanceOf[Int]))
    }
  }
}

class Multiply(left: Expression, right: Expression) extends Expression {

  override def toString() = "(" + left + "*" + right + ")"

  def isReducible(): Boolean = { true }

  def reduce(env: Environment) = {
    (left.isReducible, right.isReducible) match {
      case (true, _) => new Multiply( left.reduce(env) , right )
      case (_, true) => new Multiply( left , right.reduce(env) )
      case _ => new SimpleInteger(left.asInstanceOf[Primitive].value.asInstanceOf[Int].*(right.asInstanceOf[Primitive].value.asInstanceOf[Int]))
    }
  }

}

// Less Than binary operator reduces to a Boolean primitive, by first reducing left and right expressions and comparing
class LessThan (left: Expression, right: Expression) extends Expression {

  override def toString() = "(" + left + "<" + right + ")"

  def isReducible() : Boolean = { true }

  def reduce(env: Environment) = {
    (left.isReducible, right.isReducible) match {
      case (true, _) => new LessThan( left.reduce(env) , right )
      case (_, true) => new LessThan( left , right.reduce(env) )
      case _ => new SimpleBoolean(left.asInstanceOf[Primitive].value.asInstanceOf[Int] < (right.asInstanceOf[Primitive].value.asInstanceOf[Int]))
    }
  }

}

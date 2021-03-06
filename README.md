A Scala implementation of the toy programming language, SIMPLE, outlined in "Understanding Computation" by Tom Stuart.

The implementation does not include a text -> abstract representation parser.

This code includes a Machine that takes a abstract program structure, and executes / "reduces" the program. The program is a tree of SIMPLE constructs, where the nodes are: statements, sequences, if/else, while loop, expressions, each potentially possessing a recursive substructure. The terminal nodes / leaves include (integer and boolean) are primitives, and are not reducible. All other nodes are reducible: their subtree can be recursively reduced, until finally the node itself reduces to a primitive.

Variables reduce to a value defined in the current environment, by looking up the value of the variable. 

Statements are impure, expressions are pure. The former potentially modifies the environment.  

The reduction should be viewed as being iterative rather than recursive because each Machine Step performs a "small-step" reduction, reducing the innermost non-primitive construct. The alternative is "big-step", where a reduction of a node, will recursively reduce all it's descendents in one Machine step.  
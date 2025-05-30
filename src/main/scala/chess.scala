object chess {
  val empty: String = " . "

  sealed trait Piece {
    val color: String
    val symbol: String
    def isValidMove(from: (Int, Int), to: (Int, Int)): Boolean
  }

  case class King(color: String) extends Piece {
    val symbol = if (color == "W") "KW" else "KB"
    def isValidMove(from: (Int, Int), to: (Int, Int)): Boolean = {
      val (dx, dy) = (math.abs(from._1 - to._1), math.abs(from._2 - to._2))
      dx <= 1 && dy <= 1
    }
  }

  case class Pawn(color: String) extends Piece {
    val symbol = if (color == "W") "PW" else "PB"
    def isValidMove(from: (Int, Int), to: (Int, Int)): Boolean = {
      val direction = if (color == "W") -1 else 1
      (from._2 == to._2) && (to._1 - from._1 == direction)
    }
  }

  var board: Array[Array[Option[Piece]]] = Array.fill(8, 8)(None)

  def initBoard(): Unit = {
    // Add pawns
    for (i <- 0 until 8) {
      board(1)(i) = Some(Pawn("B"))
      board(6)(i) = Some(Pawn("W"))
    }
    // Add kings
    board(0)(4) = Some(King("B"))
    board(7)(4) = Some(King("W"))
  }

  def printBoard(): Unit = {
    println("\n   a  b  c  d  e  f  g  h")
    for (i <- 0 until 8) {
      print(s"${8 - i} ")
      for (j <- 0 until 8) {
        board(i)(j) match {
          case Some(piece) => print(s" ${piece.symbol} ")
          case None        => print(empty)
        }
      }
      println(s" ${8 - i}")
    }
    println("   a  b  c  d  e  f  g  h\n")
  }

  def parseMove(input: String): Option[((Int, Int), (Int, Int))] = {
    val pattern = "([a-h][1-8]) ([a-h][1-8])".r
    input match {
      case pattern(from, to) =>
        val (fx, fy) = (8 - from(1).asDigit, from(0) - 'a')
        val (tx, ty) = (8 - to(1).asDigit, to(0) - 'a')
        Some(((fx, fy), (tx, ty)))
      case _ => None
    }
  }

  def movePiece(from: (Int, Int), to: (Int, Int)): Boolean = {
    (board(from._1)(from._2), board(to._1)(to._2)) match {
      case (Some(piece), _) =>
        if (piece.isValidMove(from, to)) {
          board(to._1)(to._2) = board(from._1)(from._2)
          board(from._1)(from._2) = None
          true
        } else {
          println("Invalid move for that piece.")
          false
        }
      case _ =>
        println("No piece at that position.")
        false
    }
  }

  def main(args: Array[String]): Unit = {
    initBoard()
    var currentPlayer = "W"
    while (true) {
      printBoard()
      println(s"$currentPlayer's turn. Enter your move (e.g., e2 e4):")
      val input = scala.io.StdIn.readLine()

      parseMove(input) match {
        case Some((from, to)) =>
          board(from._1)(from._2) match {
            case Some(piece) if piece.color == currentPlayer =>
              if (movePiece(from, to)) {
                currentPlayer = if (currentPlayer == "W") "B" else "W"
              }
            case Some(_) => println("That's not your piece!")
            case None    => println("No piece at that square.")
          }
        case None =>
          println("Invalid input. Please use format like 'e2 e4'.")
      }
    }
  }
}

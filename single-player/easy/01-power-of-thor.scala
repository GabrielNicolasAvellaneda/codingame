import math._
import scala.util._

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
object Player extends App {
    // lightx: the X position of the light of power
    // lighty: the Y position of the light of power
    // initialtx: Thor's starting X position
    // initialty: Thor's starting Y position
    val Array(lightx, lighty, initialtx, initialty) = for(i <- readLine split " ") yield i.toInt
   
    def yDirection(dy: Int) : (String, Int) = {
        if (dy < 0) {
           ("N", -1)
        } else if (dy > 0) {
            ("S", 1)
        } else {
            ("", 0)   
        }
    }
    
    def xDirection(dx: Int): (String, Int) = {
         if (dx < 0) {
            ("W", -1)
        } else if (dx > 0) {
            ("E", 1)
        } else {
            ("", 0)   
        }
    }
    
    def calculateDirection(x1: Int, y1: Int, x2: Int, y2: Int) = {
        val dx = x2 - x1 
        val dy = y2 - y1
        
        val (yDir, yOffset) = yDirection(dy)
        val (xDir, xOffset) = xDirection(dx)
        (yDir + xDir, xOffset + x1, yOffset + y1)
    }
   
    var currenttx = initialtx 
    var currentty = initialty

    // game loop
    while(true) {
        val remainingturns = readInt // The remaining amount of turns Thor can move. Do not remove this line.
        
        // Write an action using println
        // To debug: Console.err.println("Debug messages...")
        //println("E") // A single line providing the move to be made: N NE E SE S SW W or NW
        
       var (direction, updatedTx, updatedTy) = calculateDirection(currenttx, currentty, lightx, lighty)
       currenttx = updatedTx
       currentty = updatedTy
       println(direction)
    }
}
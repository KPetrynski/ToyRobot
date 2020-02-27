package robot

import entities.Direction.*
import entities.RobotPosition

const val MIN_X = 0
const val MIN_Y = 0
const val MAX_X = 5
const val MAX_Y = 5
const val TURNING_RIGHT = 90
const val TURNING_LEFT = -90
const val FULL_CIRCLE = 360

class Robot {
    private var position: RobotPosition? = null

    fun place(newPosition: RobotPosition?) {
        if (newPosition?.x in MIN_X..MAX_X && newPosition?.y in MIN_Y..MAX_Y) {
            position = newPosition
        }
    }

    fun report() = position?.let { "${it.x},${it.y},${it.f}" }

    fun resetPosition() {
        position = null
    }

    fun move() {
        position?.let {
            when (it.f) {
                NORTH -> if (it.y < MAX_Y) it.y += 1
                EAST -> if (it.x < MAX_Y) it.x += 1
                SOUTH -> if (it.y > MIN_Y) it.y -= 1
                WEST -> if (it.x > MIN_X) it.x -= 1
            }
        }
    }

    fun turnRight() {
        turn(TURNING_RIGHT)
    }

    fun turnLeft() {
        turn(TURNING_LEFT)
    }

    private fun turn(degrees: Int) {
        position?.let {
            setNewDirection(((FULL_CIRCLE + it.f.degrees + degrees).rem(FULL_CIRCLE)))
        }
    }

    private fun setNewDirection(newOrientation: Int) {
        values().find { it.degrees == newOrientation }?.let { position?.f = it }
    }
}
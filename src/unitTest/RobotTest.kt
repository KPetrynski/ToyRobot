package unitTest

import entities.Direction.*
import entities.RobotPosition
import org.junit.Test
import robot.*
import kotlin.test.assertTrue

internal class RobotTest {

    @Test
    fun setLeftTopPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MAX_Y, NORTH))
        assertTrue { robot.report() == "$MIN_X,$MAX_Y,NORTH" }
    }

    @Test
    fun setRightBottomPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MIN_Y, NORTH))
        assertTrue { robot.report() == "$MAX_X,$MIN_Y,NORTH" }
    }

    @Test
    fun validMoveNORTH() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MIN_Y, NORTH))
        robot.move()
        assertTrue { robot.report() == "$MIN_X,${MIN_Y + 1},NORTH" }
    }

    @Test
    fun validMoveEAST() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MIN_Y, EAST))
        robot.move()
        assertTrue { robot.report() == "${MIN_X + 1},$MIN_Y,EAST" }
    }

    @Test
    fun validMoveSouth() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MAX_Y, SOUTH))
        robot.move()
        assertTrue { robot.report() == "$MAX_X,${MAX_Y - 1},SOUTH" }
    }

    @Test
    fun validMoveWest() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MAX_Y, WEST))
        robot.move()
        assertTrue { robot.report() == "${MAX_X - 1},$MAX_Y,WEST" }
    }

    @Test
    fun setInvalidMaxXPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X + 1, MIN_Y, NORTH))
        assertTrue { robot.report() == null }
    }

    @Test
    fun setInvalidMaxYPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MAX_Y + 1, NORTH))
        assertTrue { robot.report() == null }
    }

    @Test
    fun setInvalidMinXPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X - 1, MIN_Y, NORTH))
        assertTrue { robot.report() == null }
    }

    @Test
    fun setInvalidMinYPosition() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MIN_Y - 1, NORTH))
        assertTrue { robot.report() == null }
    }

    @Test
    fun turnLeft() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MAX_Y, NORTH))
        robot.turnLeft()
        assertTrue {
            robot.report() == "$MAX_X,$MAX_Y,WEST" }
    }

    @Test
    fun turnRight() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MAX_Y,NORTH))
        robot.turnRight()
        assertTrue {
            robot.report() == "$MAX_X,$MAX_Y,EAST" }
    }

    @Test
    fun northBoundary() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MAX_Y, NORTH))
        robot.move()
        assertTrue { robot.report() == "$MIN_X,$MAX_Y,NORTH" }
    }

    @Test
    fun southBoundary() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MIN_Y, SOUTH))
        robot.move()
        assertTrue { robot.report() == "$MIN_X,$MIN_Y,SOUTH" }
    }

    @Test
    fun westBoundary() {
        val robot = Robot()
        robot.place(RobotPosition(MIN_X, MIN_Y, WEST))
        robot.move()
        assertTrue { robot.report() == "$MIN_X,$MIN_Y,WEST" }
    }

    @Test
    fun eastBoundary() {
        val robot = Robot()
        robot.place(RobotPosition(MAX_X, MIN_Y, EAST))
        robot.move()
        assertTrue { robot.report() == "$MAX_X,$MIN_Y,EAST"}
    }
}
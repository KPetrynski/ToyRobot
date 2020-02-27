package robot

import entities.*

class RobotController(private val robot: Robot) {
    fun executeCommands(commands: List<Command>): List<String> {
        val reports = mutableListOf<String>()
        commands.forEach {
            when (it) {
                is Place -> robot.place(it.robotPosition.copy())
                is Move -> robot.move()
                is Left -> robot.turnLeft()
                is Right -> robot.turnRight()
                is Report -> robot.report()?.let { r -> reports.add(r) }
            }
        }
        robot.resetPosition()
        return reports
    }
}
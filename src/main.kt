import robot.Robot
import robot.RobotController
import utils.*
import java.io.File
import java.io.FileNotFoundException

fun main() {
    val robot = Robot()
    val robotController = RobotController(robot)
    startConsole(robotController)
}

private fun startConsole(robotController: RobotController) {
    println(INPUT_INSTRUCTIONS)
    var input = readLine()!!
    while (input != "e") {
        when (input) {
            "c" -> {
                print(TYPE_FILE_NAME)
                val testName = readLine()!!
                executeTestFile(robotController, TEST_PACKAGE_PATH + testName)
            }
            "a" -> File(TEST_PACKAGE_PATH).walk().forEach {
                executeTestFile(robotController, TEST_PACKAGE_PATH + it.name)
            }
            "i" -> println(INPUT_INSTRUCTIONS)
            else -> println(UNSUPPORTED_INSTRUCTION)
        }
        print(CHOOSE_INSTRUCTION)
        input = readLine()!!
    }
}

private fun executeTestFile(robotController: RobotController, path: String) {
    try {
        val commands = Utils.getCommandsFromFile(path)
        println("Test: $path")
        robotController.executeCommands(commands).forEach { report -> println(report) }
    } catch (e: FileNotFoundException) {
        println("File: $path not found")
    }
    println()
}





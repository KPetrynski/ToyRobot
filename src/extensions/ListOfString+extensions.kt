package extensions

import entities.*

fun List<String>.getCommandList(): List<Command> = this.mapIndexed { index, s ->
    when (s) {
        "PLACE" -> this.subList(index + 1, index + 4).getPlaceCommand()
        "MOVE" -> Move
        "LEFT" -> Left
        "RIGHT" -> Right
        "REPORT" -> Report
        else -> null
    }
}.filterNotNull()

private fun List<String>.getPlaceCommand() : Place? = try {
    Place(
        RobotPosition(
            this[0].toInt(),
            this[1].toInt(),
            Direction.valueOf(this[2].toUpperCase())
        )
    )
} catch (e: Exception) {
    println("Converting Place command Exception: $e")
    null
}
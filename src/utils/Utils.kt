package utils

import entities.Command
import extensions.getCommandList
import java.io.File

object Utils {
    fun getCommandsFromFile(filePath: String): List<Command> = readFileDirectlyAsText(filePath)
        .split(" ", ",")
        .getCommandList()

    private fun readFileDirectlyAsText(filePath: String): String = File(filePath).readText(Charsets.UTF_8)
}
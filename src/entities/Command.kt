package entities

sealed class Command
data class Place(val robotPosition: RobotPosition) : Command()
object Move : Command()
object Left : Command()
object Right : Command()
object Report : Command()
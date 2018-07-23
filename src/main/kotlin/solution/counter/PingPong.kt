package solution.counter

import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    val game = Game()
    game.init()
    game.play()
    Thread.sleep(1000)
    game.stop()
}

class Player(private val counter: AtomicInteger, private val turn: Int, val isLast: Boolean = false) : Runnable {

    var isPlaying = true

    override fun run() {
        while (isPlaying) {
            if (counter.get() == turn) {
                println("$turn")
                val next = if (isLast) 1 else turn + 1
                counter.set(next)
            }
        }
    }
}

class Game {
    private val counter = AtomicInteger(1)
    private val players = mutableListOf<Player>()

    fun init() {
        val player1 = Player(counter, 1)
        val player2 = Player(counter, 2)
        val player3 = Player(counter, 3, isLast = true)
        players.addAll(arrayOf(player1, player2, player3))
    }

    fun play() {
        players.map { Thread(it).start() }
    }

    fun stop() {
        players.map { it.isPlaying = false }
    }
}
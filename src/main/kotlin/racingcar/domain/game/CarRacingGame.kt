package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingGameConfiguration
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule

class CarRacingGame private constructor(
    private val cars: List<Car>,
    private val roundRange: IntRange,
    private val result: CarRacingResult,
    private val moveRule: MoveRule,
) {
    fun run(): CarRacingResult {
        roundRange.forEach { roundNumber ->
            runRound()
            record(roundNumber)
        }
        return result
    }

    private fun runRound() {
        val round = CarRacingGameRound(
            cars = cars,
            moveRule = moveRule,
        )
        round.run()
    }

    private fun record(roundNumber: Int) {
        result.record(roundNumber, cars)
    }

    companion object {
        fun set(
            configuration: CarRacingGameConfiguration,
            result: CarRacingResult,
            moveRule: MoveRule,
        ): CarRacingGame = CarRacingGame(
            cars = configuration.cars,
            roundRange = configuration.roundRange,
            result = result,
            moveRule = moveRule,
        )
    }
}

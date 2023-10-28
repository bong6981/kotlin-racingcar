package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.view.CarRacingInput

class CarRacingConfigurationTest : FunSpec({
    context("자동차 경주 설정 정보 생성시 유효성 검사") {
        test("자동차 대수가 양수가 아닌 경우 레이싱 게임 설정 정보 생성에 실패한다") {
            val carCount = 0
            val tryCount = 2

            shouldThrowExactly<IllegalArgumentException> {
                CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))
            }
        }

        test("시도 횟수가 양수가 아닌 경우 레이싱 게임 설정 정보 생성에 실패한다") {
            val carCount = 2
            val tryCount = -1

            shouldThrowExactly<IllegalArgumentException> {
                CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))
            }
        }

        test("자동차 대수와 시도 횟수가 모두 양수인 경우 레이싱 게임 설정 정보가 생성된다") {
            val carCount = 1
            val tryCount = 2

            shouldNotThrowAny {
                CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))
            }
        }
    }

    context("자동차 경주 게임 설정 정보 생성") {
        test("자동차 경주 게임 설정 정보가 생성된다") {
            val carCount = 4
            val tryCount = 2
            val configuration = CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))

            val result = configuration.getCarRacingGameConfiguration()

            result.cars.size shouldBe carCount
            result.cars.forEachIndexed { index, car ->
                car.order shouldBe index
                car.position shouldBe 0
            }
            result.rounds shouldBe 1..tryCount
        }
    }

    context("자동차 경주 결과 설정 정보 생성") {
        test("자동차 경주 결과 설정 정보가 생성된다") {
            val carCount = 4
            val tryCount = 2
            val configuration = CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))

            val result = configuration.getCarRacingResultConfiguration()

            result.roundRange shouldBe 1..tryCount
        }
    }

    context("라운드 결과 설정 정보 생성") {
        test("라운드 결과 설정 정보가 생성된다") {
            val carCount = 1
            val tryCount = 3
            val configuration = CarRacingConfiguration.of(CarRacingInput(carCount, tryCount))

            val result = configuration.getRoundResultConfiguration()

            result.cars.size shouldBe carCount
            result.cars.forEachIndexed { index, car ->
                car.order shouldBe index
                car.position shouldBe 0
            }
        }
    }
})

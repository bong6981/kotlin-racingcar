# kotlin-racingcar

## 기능목록

### step4
- [x] 경주할 자동차 이름을 입력 받는다 
  - [x] 입력 받을 때 안내 메시지는 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    " 이다
  - [x] 받은 입력에서 ","를 구분자로 이름을 추출한다
- [x] 시도할 횟수를 입력 받는다 
  - [x] 입력 받을 때 안내 메세지는 "시도할 횟수는 몇 회인가요?" 이다 
  - [x] 받은 입력에서 횟수를 정수로 변환한다
- [ ] 자동차 이름을 검증한다
  - [ ] 5자 초과 금지 
  - [ ] 경기할 자동차는 1대 이상
- [ ] 입력 받은 이름으로 자동차를 생성한다 
  - [ ] 자동차 수는 이름의 수와 같다 
  - [ ] 자동차 생성시 입력 받은 이름을 저장한다
- [ ] 시도 횟수만큼 자동차를 움직인다
  - [ ] 자동차별로 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 1칸 움직인다
- [ ] 우승자를 가린다 
  - [ ] 경기가 끝난 후 가장 많은 거리를 간 사람이 우승자다 
- [ ] 경기 실행 결과를 출력한다 
  - [ ] 실행 결과 안내 메시지는 "실행 결과" 이다 
  - [ ] `{$이름 : -- }` 형식으로 출력한다 
    - [ ] 이동한 칸만큼 - 로 표기한다 
  - [ ] 횟수별 결과 출력은 줄바꿈으로 구분한다
  - [ ] 마지막 줄에 우승자를 출력한다 
    - [ ] ${${이름}, ${이름}가 최종 우승했습니다.}`형식으로 출력한다 
    - [ ] 우승자가 여러 명일 경우 쉼표로 구분한다

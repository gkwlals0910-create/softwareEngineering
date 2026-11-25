// 게임 실행 시 나타나는 title 장면 클래스
public class TitleScene {
    //final은 절대 바뀌지 않음. 덮어쓰기 금지. 다만, 내부 값 변경은 가능
    private static final String RESET  = "\u001B[0m";  // 색상 및 스타일 초기화
    private static final String BOLD   = "\u001B[1m";  // 굵은 글씨
    private static final String CYAN   = "\u001B[36m"; // 청록색 (테두리용)
    private static final String YELLOW = "\u001B[33m"; // 노란색 (제목 강조용)
    private static final String GRAY   = "\u001B[90m"; // 회색 (부제목 및 구분선용)

    // 오탈자 및 범위 오류를 방지
    private InputHelper input;

    // 생성자
    public TitleScene(InputHelper input) {
        this.input = input;
    }

    /**
     * 타이틀 화면을 출력하고 사용자의 메뉴 선택을 처리하는 메서드
     * @return 1번(게임 시작) 선택 시 true, 2번(나가기) 선택 시 false 반환
     */
    public boolean start() {
        // 1. 상단 게임 제목 배너 출력
        printBanner();

        // 2. 선택지 메뉴 출력
        System.out.println();
        System.out.println("  " + BOLD + "1." + RESET + " 던전 입장하기 (게임 시작)");
        System.out.println("  " + BOLD + "2." + RESET + " 나가기");
        System.out.println();
        System.out.println(GRAY + "────────────────────────────────────────────────────────" + RESET);

        // 3. 1 ~ 2 사이의 정수만 안전하게 입력받음 (문자나 범위 밖 숫자는 내부에서 재입력 유도)
        int choice = input.readInt("  > 선택: ", 1, 2);

        // 4. 선택 결과에 따라 게임 진행 여부 반환
        if (choice == 1) {
            System.out.println(); 
            return true;
        }
        else {
            return false;
        }
    }

    // 상단 타이틀 배너 출력만 전담하는 내부 메서드 (start 메서드의 가독성을 위해 분리)
    private void printBanner() {
        System.out.println(CYAN + "════════════════════════════════════════════════════════" + RESET);
        System.out.println();
        System.out.println(YELLOW + BOLD + "              [  T h e  G l u t t o n ' s  G a t e  ]" + RESET);
        System.out.println(BOLD + "                    - 탐식의 문지기 -" + RESET);
        System.out.println();
        System.out.println(GRAY + "          \"문지기를 만족시키는 음식을 만들어라.\"" + RESET);
        System.out.println();
        System.out.println(CYAN + "════════════════════════════════════════════════════════" + RESET);
    }
}
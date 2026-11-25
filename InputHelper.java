import java.util.Scanner;

public class InputHelper {

    private Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    // 지정된 범위(min ~ max) 내의 정수만 안전하게 입력받음
    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                else {
                    System.out.printf("  [!] %d부터 %d 사이의 숫자를 입력해주세요.%n", min, max);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("  [!] 숫자만 입력 가능합니다.");
            }
        }
    }

    // 빈 문자열이 아닌 텍스트 입력 (이름 등)
    public String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            else {
                System.out.println("  [!] 내용을 입력해주세요.");
            }
        }
    }
}
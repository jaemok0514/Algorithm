import java.util.Scanner;

public class ToLowerCase {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine(); //문자열 입력 받기
        String result = "";

        if(s.length() >= 1 && s.length() <= 100) { //길이가 1 ~ 100 사이일 때
            char[] arr = s.toCharArray(); //arr에 char형으로 하나씩 저장
            for(char c : arr) { //arr에 저장된 값 하나 씩 가져옴
                if(c >= 65 && c <= 90) { //c가 A~Z사이일때
                    result += (char) (c + 32); //result에 소문자로 바꿔서 저장
                } else { //그 외 일때
                    result += c; //그대로 저장
                }
            }
        } else {
            System.out.println("범위를 확인하세요");
        }
        System.out.println(result);
        System.out.println(result.getClass().getName());
        scan.close();
    }
}
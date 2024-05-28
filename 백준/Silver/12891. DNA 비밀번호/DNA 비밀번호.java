import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  //1:48시작
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] lens = br.readLine().split(" ");
    int s = Integer.parseInt(lens[0]); //dna문자열 길이
    int p = Integer.parseInt(lens[1]); //부분 문자열 길이
    String dna = br.readLine();
    String[] mins = br.readLine().split(" "); //각 문자가 사용될 최소 횟수
    int minA = Integer.parseInt(mins[0]);
    int minC = Integer.parseInt(mins[1]);
    int minG = Integer.parseInt(mins[2]);
    int minT = Integer.parseInt(mins[3]);

    int start = 0;
    int end = start + p - 1;
    int answer = 0; //만들 수 있는 비밀번호의 갯수

    int cntA = 0, cntC = 0, cntG = 0, cntT = 0;
    for (int i = start; i <= end; i++) {
      if (dna.charAt(i) == 'A') {
        cntA++;
      } else if (dna.charAt(i) == 'C') {
        cntC++;
      } else if (dna.charAt(i) == 'G') {
        cntG++;
      } else if (dna.charAt(i) == 'T') {
        cntT++;
      }
    }

    while (end < s) {

//      System.out.println("======");
//      System.out.println("cntA = " + cntA);
//      System.out.println("cntC = " + cntC);
//      System.out.println("cntG = " + cntG);
//      System.out.println("cntT = " + cntT);

      if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT) {
        answer++;
      }

      if (end + 1 == s) {
        break;
      }

      if (dna.charAt(start) == 'A') {
        cntA--;
      } else if (dna.charAt(start) == 'C') {
        cntC--;
      } else if (dna.charAt(start) == 'G') {
        cntG--;
      } else if (dna.charAt(start) == 'T') {
        cntT--;
      }

      start++;
      end++;

//      System.out.println("start = " + start);
//      System.out.println("end = " + end);

      if (dna.charAt(end) == 'A') {
        cntA++;
      } else if (dna.charAt(end) == 'C') {
        cntC++;
      } else if (dna.charAt(end) == 'G') {
        cntG++;
      } else if (dna.charAt(end) == 'T') {
        cntT++;
      }


    }

    System.out.println(answer);
  }

}

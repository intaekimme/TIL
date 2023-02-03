package softeer;

import java.util.*;
import java.io.*;

/**
 * 21년 재직자 대회 예선
 * 좌석 관리_fail
 * 너무 어렵게 풀음
 * 
 * 
 * n * m 행렬, (1,1) ~(N, M) 배열 사이즈 (n+1, m+1)
 * 
 * 안전도 : 위치 (X,Y)의 안전도는 주변의 다른 i개의 사람이 앉아있는 좌석들중 최소 거리 값
 * 사람이 앉을 수 있는 좌석의 조건 : 현재 위치의 상하좌우 인접한 위치에 사람이 있으면 안됨
 * 
 * 사람 배치
 * 현재 비어 있는 좌석 중
 * 1. 방역수칙 고려 (상하좌우 인접한 위치에 사람 있으면 안됨)
 * 2. 안전도 가장 높은 좌석
 * 3. 안전도 가장 높은 좌석의 조건 -> 1) x가 가장 낮은 좌석, x가 같으면 y가 가장 낮은 좌석, 그런 좌석이 없다면 (1,1)
 * 
 * 사원이 떠남
 * 사원이 떠난 자리는 빈자리
 * 사원의 점심 식사 여부 처리 필요
 * 
 * 입력 형식
 * 사원 번호로 명령이 들어옴
 * 사원 상태 확인을 hashset 자료형으로 조회, key, value로 매칭
 * 
 * 사원 초기상태
 * 식사전, 좌석 위치 원점
 * 처음 조회하는 사원은 hashset.contain 함수 사용시 false return
 * 
 * 맵 배열 자료형(좌석)
 * 
 * 좌석 클래스
 * 좌석 위치 int[]
 * 현재 안전도 int
 * 사원 - 없으면 null
 * 
 * 사원 클래스
 * 점심 식사 여부 - 식사전, 중, 후 Enum or int 0, 1, 2
 * 앉은 좌석의 위치 - 없으면 (21, 21), 있으면 (1,1) ~ (n,m) 사이의 좌표 int[]
 * 
 * in 명령 처리 과정
 * 1. in 명령이 들어오면 현재 사원의 존재여부 판단 - hashset.contain
 * 1) 존재하지 않는 사원 - return false -> 식사를 한 번이라도 한 사원은 hashset에 요소가 있으므로 존재하지 않는
 * 사원은 식사 전 사원
 * -> 자리 배치 가능 여부 확인
 * -> return (x,y) or (1,1) : 자리 배치 가능 시 -> 격자에 사원 추가, 안전도 갱신, 사원은 식사중 상태로 갱신해
 * hashset과 격자 업데이트
 * -> {id} gets the seat{{x}, {y}} 출력 -> 다음 명령 입력
 * -> return (21, 21) : There are no more seats 출력 -> 다음 명령 입력
 * 2) 존재하는 사원 -> return true -> 식사여부 판단
 * -> 식사중인 경우 -> {id} alredy seated 출력 -> 다음 명령 입력
 * -> 식사 완료한 경우 -> {id} already ate lunch 출력 -> 다음 명령 입력
 * 
 * 2. 자리 배치 가능 여부 확인
 * 1. 좌석 자료형의 우선순위 큐 생성 후,
 * 2. 격자 전체를 탐색하며 사원이 null인 좌석 탐색
 * 3. 사원이 null인 좌석을 발견하면 사방탐색 시작
 * 3-1. 사방탐색에서 하나라도 사원이 null이 아니면 앉을 수 없는 좌석
 * 3-2. 유효성 검사 통과하면 우선순위 큐에 넣어줌
 * 4. 격자 전체 탐색을 마치면 최상단의 원소를 빼서 반환
 * 
 * out 명령 처리 과정
 * 1. 사원 존재 여부 판단 : hashmap.contain
 * 1) 존재하지 않는 사원 - return false -> 아직 식사를 하지 못한 사원, {id} didn't eat lunch 출력 ->
 * 다음 명령 입력
 * 2) 존재하는 사원 - return true -> 식사여부 판단
 * -> 식사 중인 경우 -> {id} leaves from the seat{{x},{y}} 출력, 식사 완료 상태로 갱신해 haset과 격자
 * 업데이트 -> 다음 명령 입력
 * -> 식사 완료 경우 -> {id} already left seat 출력 -> 다음 명령 입력
 */

public class Main_1 {

    static final int MAX_N = 20;

    static int n, m, q;
    static String[] cmd_query; // 명령 : 문자열
    static int[] cmd_emp_num; // 명령 : 사원 번호

    static Seat[][] map; // 좌석 배열 격자

    static HashMap<Integer, Employee> hashmap = new HashMap<>(); // 사원 관리
    static PriorityQueue<Seat> que; // 가장 높은 안전도 좌석 관리

    static StringBuilder sb = new StringBuilder(); // 출력 버퍼

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // 명령어 저장
        cmd_query = new String[q];
        cmd_emp_num = new int[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            cmd_query[i] = st.nextToken();
            cmd_emp_num[i] = Integer.parseInt(st.nextToken());
        }

        // 격자 생성
        map = new Seat[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                map[i][j] = new Seat(new int[] { i, j });

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }// end of outOfRange

    public static boolean isCanGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        Seat curSeat = map[x][y];
        if (curSeat.getEmployee() == null)
            return false;
        return true;
    }// end of isCanGo

    public static boolean isPossible(int x, int y) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isCanGo(nx, ny))
                return false;
        }

        return true;

    }// end of isPossible

    public static int[] getPossiblePos() {
        // 2. 자리 배치 가능 여부 확인
        // 1. 좌석 자료형의 우선순위 큐 생성 후,
        que = new PriorityQueue<Seat>();
        // 2. 격자 전체를 탐색하며 사원이 null인 좌석 탐색

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                Seat curSeat = map[x][y];
                if (curSeat.getEmployee() == null) {
                    // 3. 사원이 null인 좌석을 발견하면 사방탐색 시작
                    // 3-1. 사방탐색에서 하나라도 사원이 null이 아니면 앉을 수 없는 좌석
                    if (isPossible(x, y))
                        // 3-2. 유효성 검사 통과하면 우선순위 큐에 넣어줌
                        que.offer(curSeat);
                }
            }
        }

        // 4. 격자 전체 탐색을 마치면 최상단의 원소를 빼서 반환
        Seat res = que.poll();
        return res.getPos();

    }// end of getPossiblePos

    public static void excuteInCmd(int emp_num) {
        // in 명령 처리 과정
        // 1. in 명령이 들어오면 현재 사원의 존재여부 판단 - hashmap.containsKey
        if (hashmap.containsKey(emp_num)) {
            // 2) 존재하는 사원 -> return true -> 식사여부 판단
            Employee findEmp = hashmap.get(emp_num);
            // -> 식사중인 경우 -> {id} alredy seated 출력 -> 다음 명령 입력
            if (findEmp.getEatStatus() == 1)
                sb.append(emp_num).append(" already seated.").append("\n");
            // -> 식사 완료한 경우 -> {id} already ate lunch 출력 -> 다음 명령 입력
            if (findEmp.getEatStatus() == 2)
                sb.append(emp_num).append(" already ate lunch.").append("\n");
        } else {
            // 1) 존재하지 않는 사원 - return false -> 식사를 한 번이라도 한 사원은 hashset에 요소가 있으므로 존재하지 않는
            // 사원은 식사 전 사원
            // -> 자리 배치 가능 여부 확인
            int[] new_pos = getPossiblePos();
            // -> return (21, 21) : There are no more seats 출력 -> 다음 명령 입력
            if (new_pos[0] == 21 && new_pos[1] == 21)
                sb.append("There are no more seats.").append("\n");
            else {
                // -> return (x,y) or (1,1) : 자리 배치 가능 시 -> 격자에 사원 추가, 사원은 식사중 상태로 갱신해 hashmap에
                // 추가
                int x = new_pos[0];
                int y = new_pos[1];
                Seat possibleSeat = map[x][y];
                // 격자에 사원 추가
                possibleSeat.seatEmployee(new_pos);
                Employee cur_emp = possibleSeat.getEmployee();
                // 사원 식사 상태 식사중으로 갱신
                cur_emp.updateStatus(1);
                // hashmap에 사원 추가
                hashmap.put(emp_num, cur_emp);

                sb.append(emp_num).append(" get the seat (").append(x).append(", ").append(y).append("). \n");

                // -> {id} gets the seat{{x}, {y}} 출력 -> 다음 명령 입력
            }
        } // end of else

    }// end of excuteInCmd

    public static void excuteOutCmd(int emp_num) {
        // out 명령 처리 과정
        // 1. 사원 존재 여부 판단 : hashmap.containsKey
        if (hashmap.containsKey(emp_num)) {
            // 2) 존재하는 사원 - return true -> 식사여부 판단
            // -> 식사 중인 경우 -> {id} leaves from the seat{{x},{y}} 출력, 식사 완료 상태로 갱신해 haset과 격자
            // 업데이트 -> 다음 명령 입력
            Employee findEmp = hashmap.get(emp_num);
            if (findEmp.getEatStatus() == 1) {
                // 사원 식사 상태 완료로 갱신
                findEmp.updateStatus(2);

                int[] pos = findEmp.getPos();
                int x = pos[0];
                int y = pos[1];

                Seat curSeat = map[x][y];
                // 현재 좌석에서 사원 떠남
                curSeat.leaveEmployee();

                sb.append(emp_num).append(" leaves from the seat (").append(x).append(", ").append(y).append("). \n");
            }
            if (findEmp.getEatStatus() == 2)
                sb.append(emp_num).append(" already left seat. \n");
            // -> 식사 완료 경우 -> {id} already left seat 출력 -> 다음 명령 입력

        } else {
            // 1) 존재하지 않는 사원 - return false -> 아직 식사를 하지 못한 사원, {id} didn't eat lunch 출력 ->
            // 다음 명령 입력
            sb.append(emp_num).append(" didn't eat lunch. \n");
        }
    }// end of excuteOutCmd

    public static void sol() {
        // 명령어 1개씩 수행
        for (int i = 0; i < q; i++) {
            if (cmd_query[i].equals("In"))
                excuteInCmd(cmd_emp_num[i]);
            else
                excuteOutCmd(cmd_emp_num[i]);
        }

        // 정답 출력
        System.out.println(sb.toString());
    }// end of sol

    public static void main(String args[]) throws IOException {
        init();
        sol();
    }// end of main

}// end of class

class Employee {
    int eatStatus = 0; // 0 : before, 1 : eatting, 2 : eatten
    int[] pos = new int[] { 21, 21 };

    public Employee(int[] new_pos) {
        this.pos = new_pos;
    }

    // 현재 사원의 식사 상태 반환
    public int getEatStatus() {
        return this.eatStatus;
    }

    // 현재 사원의 위치 반환
    public int[] getPos() {
        return this.pos;
    }

    // 사원의 식사 상태 갱신
    public void updateStatus(int eatStatus) {
        this.eatStatus = eatStatus;
    }

    // 사원의 위치 갱신
    public void updatePos(int[] new_pos) {
        this.pos = new_pos;
    }

}// end of Employee

class Seat implements Comparable<Seat> {
    int[] pos;
    int safety = Integer.MIN_VALUE;
    Employee emp = null;

    // 현 위치에 좌석생성, 격자 생성시 사용
    public Seat(int[] new_pos) {
        this.pos = new_pos;
    }

    // 좌석의 안전도 업데이트
    public void updateSafety(int safety) {
        this.safety = safety;
    }

    // 사원이 좌석에 앉음
    public void seatEmployee(int[] new_pos) {
        this.emp = new Employee(new_pos);
    }

    // 사원이 좌석을 떠남
    public void leaveEmployee() {
        this.emp = null;
    }

    // 좌석에 앉은 사원 반환
    public Employee getEmployee() {
        return this.emp;
    }

    // 좌석 위치 반환
    public int[] getPos() {
        return this.pos;
    }

    @Override
    public int compareTo(Seat s) {
        if (this.pos[0] == s.pos[0])
            return this.pos[1] - s.pos[1]; // x좌표 동일한 경우, y좌표 오름차순 정렬
        return this.pos[0] - s.pos[0]; // x좌표 동일한 경우 없는 경우, x좌표 오름차순 정렬
    }

}// end of seat

class Solution {
    public long solution(int n, int[] times) {
        
        long ans = 0;
        
        long low = 1; // 최소 시간 (0은 불가능하므로 1로 시작)
        long high = 0; // 최대 시간 (각 심사관이 가장 오래 걸리는 시간 * n)
        
        for (int time : times) {
            if (time > high) {
                high = time;
            }
        }
        high = high * n; // 가장 오래 걸리는 시간에 n을 곱한 값

        long mid;
        while (low <= high) {
            mid = (low + high) / 2;
            long available = 0; // mid 시간 동안 심사 가능한 사람 수

            for (int time : times) {
                available += mid / time;
            }

            if (available >= n) { // 심사 가능한 인원이 n명 이상이면
                high = mid - 1; // 더 적은 시간을 시도
            } else { // 심사 가능한 인원이 n명 미만이면
                low = mid + 1; // 더 많은 시간을 시도
            }
        }

        return low; // low가 정답
    }
}
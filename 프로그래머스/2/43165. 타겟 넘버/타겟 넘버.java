class Solution {
    
    public int count = 0;
        
    public int solution(int[] numbers, int target) {
        
        int answer = 0;
        dfs(numbers, target, 0, 0);
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int d, int s) {
	    
        if(d == numbers.length){
            if(s == target) count++;
            return;
        }
        
        int plus = s + numbers[d];
        int minus = s - numbers[d];
        
        dfs(numbers, target, d + 1, plus);
        dfs(numbers, target, d + 1, minus);
    }
}
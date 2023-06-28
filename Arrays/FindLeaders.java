
/*
Find Leaders in an array 
leaders: if for a particular element, all the elements on its right are smaller than it
    e.g: arr=[7,10,4,3,6,5,2]
    o/p: 10,6,5,2
*/

public class FindLeaders
{
    
    //Approach1: O(n^2)
    static void findLeaders(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                System.out.print(arr[i] + " ");
        }
    }
    
    //Approach2: O(n) -> The idea is to start traversing from the right 
    // but the problem is it will print the leader from the last 
    // so, we can use an array to store the elements and then reverse it to display the ans 
    // space : O(n) and time = O(n) for reversing
    
    static void findLeaders2(int arr[]) {
        // the last element is always a leader, so print it
        int n = arr.length;
        int curr_leader = arr[n-1];
        System.out.print(curr_leader + " ");
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > curr_leader) {
                curr_leader = arr[i];
                System.out.print(curr_leader + " ");
            }
        }
    }
    
	public static void main(String[] args) {
		int arr[] = {7,10,4,3,6,5,2};
		findLeaders(arr);
		System.out.println();
		findLeaders2(arr);
	}
}

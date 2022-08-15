//Учитывая два целых nчисла и k, верните все возможные комбинации k чисел из диапазона [1, n].
//Вы можете вернуть ответ в любом порядке.

//Пример 1:
//Входные данные: n = 4, k = 2
//Вывод:
//[
//[2,4],
// [3,4],
// [2,3],
// [1,2],
// [1,3],
// [1,4],
//]
//Пример 2:
//Входные данные: n = 1, k = 1
//Вывод: [[1]]

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
    public static void combination(List<List<Integer>> result, List<Integer> list, int start, int n, int k){
        if(k == 0){
        result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n - k + 1; i++){ 
            list.add(i);
            combination(result, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}

// Java program for the above approach
public class GFG {

	// Function to print the maximum rooks
	// and their positions
	private static void countRooks(int n, int k,
								int pos[][])
	{
		int row[] = new int[n];
		int col[] = new int[n];

		// Initialize row and col array
		for (int i = 0; i < n; i++) {
			row[i] = 0;
			col[i] = 0;
		}

		// Marking the location of
		// already placed rooks
		for (int i = 0; i < k; i++) {
			row[pos[i][0] - 1] = 1;
			col[pos[i][1] - 1] = 1;
		}

		int res = n - k;

		// Print number of non-attacking
		// rooks that can be placed
		System.out.println(res + " ");

		// To store the placed rook
		// location
		int ri = 0, ci = 0;
		while (res-- > 0) {

			// Print lexicographically
			// smallest order
			while (row[ri] == 1) {
				ri++;
			}
			while (col[ci] == 1) {
				ci++;
			}
			System.out.println(
				(ri + 1)
				+ " " + (ci + 1)
				+ " ");
			ri++;
			ci++;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{

		// Size of board
		int N = 4;

		// Number of rooks already placed
		int K = 2;

		// Position of rooks
		int pos[][] = { { 1, 4 }, { 2, 2 } };

		// Function call
		countRooks(N, K, pos);
	}
}


//Реализовать алгоритм сортировки слиянием

public class ExampleMergeSort {
  
    public static void main(String[] args) {
      
        int[] num = { 3,6,1,7,2,8,10,4,9,5};
        int n = num.length;
         
        mergeSort(num, 0, n - 1);
         
        for (int h = 0; h < n; h++)
            System.out.print(num[h]+ " ");
    }
  
   
    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) { 
            int mid = (low + high) / 2; 
            mergeSort(elements, low, mid); 
            mergeSort(elements, mid + 1, high); 
            merge(elements, low, mid, high); 
        }
    }
  
    
    private static void merge(int[] subset, int low, int mid, int high) {
  
        int n = high-low+1;
        int[] Temp = new int[n];
         
        int i = low, j = mid + 1;
        int k = 0;
         
        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = subset[j++];
            else if (j > high)
                Temp[k++] = subset[i++];
            else if (subset[i] < subset[j])
                Temp[k++] = subset[i++];
            else
                Temp[k++] = subset[j++];
        }
        for (j = 0; j < n; j++)
            subset[low + j] = Temp[j];
    } 
}


Output:

1 2 3 4 5 6 7 8 9 10 


public static int[] sort(int[] arr){
	if(arr.length < 2) return arr;
	int m = arr.length / 2;
	int[] arr1 = Arrays.copyOfRange(arr, 0, m);
	int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
	return merge(sort(arr1), sort(arr2));
}
//слияние двух массивов в один отсортированный
public static int[] merge(int[] arr1,int arr2[]){
	int n = arr1.length + arr2.length;
	int[] arr = new int[n];
	int i1=0;
	int i2=0;
	for(int i=0;i<n;i++){
		if(i1 == arr1.length){
			arr[i] = arr2[i2++];				
		}else if(i2 == arr2.length){
			arr[i] = arr1[i1++];
		}else{
			if(arr1[i1] < arr2[i2]){
				arr[i] = arr1[i1++];
			}else{
				arr[i] = arr2[i2++];
			}
		}
	}
	return arr;
}




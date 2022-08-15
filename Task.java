//Учитывая два целых n числа и k, верните все возможные комбинации k чисел из диапазона [1, n].
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

import java.io.PrintStream;
import java.util.*;

public class CombinationCalc<T> {
    private void getSubsets(List<T> input, int length, int index, Set<T> currentSet, List<Set<T>> solution) {
        if (currentSet.size() == length) {
            solution.add(new HashSet<>(currentSet));
            return;
        }
        if (index == input.size()) {
            return;
        }
        T x = input.get(index);
        currentSet.add(x);
        getSubsets(input, length, index + 1, currentSet, solution);
        currentSet.remove(x);
        getSubsets(input, length, index + 1, currentSet, solution); 
    
    }

    public List<Set<T>> getSubsets(List<T> input, int length) {
        List<Set<T>> solution = new ArrayList<>();
        getSubsets(input, length, 0, new HashSet<>(), solution);
        return solution;
    }

    public void printSolution(List<Set<T>> solution, PrintStream ps) {
        Iterator<Set<T>> solutionIterator = solution.iterator();
        ps.print("[");
        if (!solutionIterator.hasNext()) {
            ps.print("]");
        }
        while (solutionIterator.hasNext()) {
            Set<T> solutionEntry = solutionIterator.next();
            Iterator<T> setEntry = solutionEntry.iterator();
            ps.print("[");
            if (!setEntry.hasNext()) {
                ps.print("]");
            }
            while (setEntry.hasNext()) {
                T entry = setEntry.next();
                ps.print(entry);
                if (setEntry.hasNext()) {
                    ps.print(", ");
                } else {
                    ps.print("]");
                }
            }
            if (solutionIterator.hasNext()) {
                ps.print(", ");
            } else {
                ps.print("]");
            }
        }
        ps.println();
    }


    public static void main(String[] args) {
        CombinationCalc<Integer> calc = new CombinationCalc<>();
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Set<Integer>> solution = calc.getSubsets(input, 2);

        calc.printSolution(solution, System.out);
    }
}

Output:

[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]



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








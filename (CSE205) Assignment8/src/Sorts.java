import java.util.Comparator;

// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 AM MWF
//  Description: The class sorts the array
public class Sorts {

	public static void sort(Movie[] list, int size, Comparator<Movie> comp) {
		
		 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < size-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < size; j++)
                if (comp.compare(list[j], list[minIndex]) < 0)
                    minIndex = j;
 
            // Swap the found minimum element with the first
            // element
            Movie temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
	}
}

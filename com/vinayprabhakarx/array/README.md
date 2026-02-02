# Complete Java Array Notes

## Table of Contents
1. What is an Array?
2. Array Declaration and Initialization
3. Types of Arrays
4. Accessing Array Elements
5. Array Properties
6. Array Methods (Arrays Class)
7. Iterating Through Arrays
8. Multidimensional Arrays
9. Array Operations
10. Common Array Problems
11. Array vs ArrayList
12. Important Points & Best Practices

---

## 1. What is an Array?

An **array** is a collection of elements of the same data type stored in contiguous memory locations.

**Characteristics:**
- Fixed size (cannot be changed after creation)
- Stores elements of the same type
- Index starts from 0
- Stored in contiguous memory

**Advantages:**
- Fast access using index (O(1) time)
- Memory efficient
- Cache friendly

**Disadvantages:**
- Fixed size
- Insertion and deletion are costly
- Wastage of memory if not fully utilized

---

## 2. Array Declaration and Initialization

### Declaration Syntax
```java
// Syntax 1
dataType[] arrayName;

// Syntax 2
dataType arrayName[];
```

### Examples of Declaration
```java
int[] numbers;          // Preferred way
String[] names;
double[] prices;
boolean[] flags;
int numbers[];          // Valid but not preferred
```

### Initialization

#### Method 1: Declaration + Memory Allocation + Assignment
```java
int[] numbers;                    // Declaration
numbers = new int[5];            // Memory allocation
numbers[0] = 10;                 // Assignment
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;
```

#### Method 2: Declaration + Memory Allocation Together
```java
int[] numbers = new int[5];
numbers[0] = 10;
numbers[1] = 20;
// Rest elements are initialized to default values (0 for int)
```

#### Method 3: Declaration + Initialization (Array Literal)
```java
int[] numbers = {10, 20, 30, 40, 50};

// Or
int[] numbers = new int[]{10, 20, 30, 40, 50};
```

#### Method 4: Anonymous Array
```java
printArray(new int[]{1, 2, 3, 4, 5});

void printArray(int[] arr) {
    // code
}
```

### Default Values
```java
int[] numbers = new int[3];      // {0, 0, 0}
double[] prices = new double[3]; // {0.0, 0.0, 0.0}
boolean[] flags = new boolean[3];// {false, false, false}
String[] names = new String[3];  // {null, null, null}
char[] chars = new char[3];      // {'\u0000', '\u0000', '\u0000'}
```

---

## 3. Types of Arrays

### Single Dimensional Array
```java
int[] arr = {1, 2, 3, 4, 5};
```

### Two-Dimensional Array (Matrix)
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Or
int[][] matrix = new int[3][3];
```

### Three-Dimensional Array
```java
int[][][] cube = new int[3][3][3];

// Or
int[][][] cube = {
    {{1, 2}, {3, 4}},
    {{5, 6}, {7, 8}}
};
```

### Jagged Array (Array of Arrays with different sizes)
```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];  // First row has 2 columns
jagged[1] = new int[4];  // Second row has 4 columns
jagged[2] = new int[3];  // Third row has 3 columns

// Or
int[][] jagged = {
    {1, 2},
    {3, 4, 5, 6},
    {7, 8, 9}
};
```

---

## 4. Accessing Array Elements

### Single Dimensional
```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]);  // 10
System.out.println(numbers[2]);  // 30
System.out.println(numbers[4]);  // 50

// Modify
numbers[1] = 100;
System.out.println(numbers[1]);  // 100
```

### Two-Dimensional
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[0][0]);  // 1
System.out.println(matrix[1][2]);  // 6
System.out.println(matrix[2][1]);  // 8

// Modify
matrix[1][1] = 100;
System.out.println(matrix[1][1]);  // 100
```

### ArrayIndexOutOfBoundsException
```java
int[] arr = {1, 2, 3};
System.out.println(arr[5]);  // Runtime Error: ArrayIndexOutOfBoundsException
```

---

## 5. Array Properties

### `length` Property
```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println(numbers.length);  // 5

// For 2D array
int[][] matrix = new int[3][4];
System.out.println(matrix.length);      // 3 (number of rows)
System.out.println(matrix[0].length);   // 4 (number of columns in first row)
```

### Finding Last Element
```java
int[] arr = {10, 20, 30, 40, 50};
int lastElement = arr[arr.length - 1];
System.out.println(lastElement);  // 50
```

---

## 6. Arrays Class Methods (java.util.Arrays)

### Import Statement
```java
import java.util.Arrays;
```

### 1. `toString()` - Convert to String
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(arr));  // [1, 2, 3, 4, 5]
```

### 2. `deepToString()` - For Multidimensional Arrays
```java
int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
System.out.println(Arrays.deepToString(matrix));  
// [[1, 2], [3, 4], [5, 6]]
```

### 3. `sort()` - Sorting
```java
int[] numbers = {5, 2, 8, 1, 9};
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers));  // [1, 2, 5, 8, 9]

// Sort in descending order (for Integer wrapper)
Integer[] nums = {5, 2, 8, 1, 9};
Arrays.sort(nums, Collections.reverseOrder());
System.out.println(Arrays.toString(nums));  // [9, 8, 5, 2, 1]

// Sort a portion
int[] arr = {5, 2, 8, 1, 9, 3};
Arrays.sort(arr, 1, 4);  // Sort from index 1 to 3
System.out.println(Arrays.toString(arr));  // [5, 1, 2, 8, 9, 3]
```

### 4. `binarySearch()` - Search Element
```java
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int index = Arrays.binarySearch(arr, 5);
System.out.println(index);  // 4

// If not found
int notFound = Arrays.binarySearch(arr, 10);
System.out.println(notFound);  // -10 (-(insertion_point + 1))
```

### 5. `fill()` - Fill with Value
```java
int[] arr = new int[5];
Arrays.fill(arr, 10);
System.out.println(Arrays.toString(arr));  // [10, 10, 10, 10, 10]

// Fill a range
int[] numbers = {1, 2, 3, 4, 5};
Arrays.fill(numbers, 1, 4, 0);
System.out.println(Arrays.toString(numbers));  // [1, 0, 0, 0, 5]
```

### 6. `copyOf()` - Copy Array
```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = Arrays.copyOf(original, 3);
System.out.println(Arrays.toString(copy));  // [1, 2, 3]

// Copy with extended length
int[] extended = Arrays.copyOf(original, 7);
System.out.println(Arrays.toString(extended));  // [1, 2, 3, 4, 5, 0, 0]
```

### 7. `copyOfRange()` - Copy Range
```java
int[] original = {1, 2, 3, 4, 5, 6, 7};
int[] range = Arrays.copyOfRange(original, 2, 5);
System.out.println(Arrays.toString(range));  // [3, 4, 5]
```

### 8. `equals()` - Compare Arrays
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
int[] arr3 = {1, 2, 4};

System.out.println(Arrays.equals(arr1, arr2));  // true
System.out.println(Arrays.equals(arr1, arr3));  // false
```

### 9. `deepEquals()` - Compare Multidimensional Arrays
```java
int[][] arr1 = {{1, 2}, {3, 4}};
int[][] arr2 = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepEquals(arr1, arr2));  // true
```

### 10. `compare()` - Lexicographical Comparison (Java 9+)
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 4};

System.out.println(Arrays.compare(arr1, arr2));  // -1 (arr1 < arr2)
```

### 11. `mismatch()` - Find First Difference (Java 9+)
```java
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = {1, 2, 5, 4, 5};

int index = Arrays.mismatch(arr1, arr2);
System.out.println(index);  // 2
```

### 12. `asList()` - Convert to List
```java
String[] fruits = {"Apple", "Banana", "Orange"};
List<String> list = Arrays.asList(fruits);
System.out.println(list);  // [Apple, Banana, Orange]
```

### 13. `stream()` - Create Stream (Java 8+)
```java
int[] numbers = {1, 2, 3, 4, 5};
int sum = Arrays.stream(numbers).sum();
System.out.println(sum);  // 15

int max = Arrays.stream(numbers).max().getAsInt();
System.out.println(max);  // 5
```

### 14. `parallelSort()` - Parallel Sorting (Java 8+)
```java
int[] arr = {5, 2, 8, 1, 9, 3, 7, 6, 4};
Arrays.parallelSort(arr);
System.out.println(Arrays.toString(arr));
```

### 15. `setAll()` - Set Using Generator (Java 8+)
```java
int[] arr = new int[5];
Arrays.setAll(arr, i -> i * 2);
System.out.println(Arrays.toString(arr));  // [0, 2, 4, 6, 8]
```

### 16. `parallelPrefix()` - Cumulative Operation (Java 8+)
```java
int[] arr = {1, 2, 3, 4, 5};
Arrays.parallelPrefix(arr, (a, b) -> a + b);
System.out.println(Arrays.toString(arr));  // [1, 3, 6, 10, 15]
```

---

## 7. Iterating Through Arrays

### Using for Loop
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### Using Enhanced for Loop (for-each)
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
```

### Using while Loop
```java
int[] numbers = {10, 20, 30, 40, 50};
int i = 0;

while (i < numbers.length) {
    System.out.println(numbers[i]);
    i++;
}
```

### Using Stream (Java 8+)
```java
int[] numbers = {10, 20, 30, 40, 50};

Arrays.stream(numbers).forEach(System.out::println);
```

### Reverse Iteration
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = numbers.length - 1; i >= 0; i--) {
    System.out.println(numbers[i]);
}
```

---

## 8. Multidimensional Arrays

### 2D Array Declaration and Initialization
```java
// Method 1
int[][] matrix = new int[3][3];

// Method 2
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Method 3
int[][] matrix = new int[3][3];
matrix[0][0] = 1;
matrix[0][1] = 2;
// ... and so on
```

### Traversing 2D Array
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Using nested for loop
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}

// Using enhanced for loop
for (int[] row : matrix) {
    for (int element : row) {
        System.out.print(element + " ");
    }
    System.out.println();
}
```

### Jagged Array
```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        System.out.print(jagged[i][j] + " ");
    }
    System.out.println();
}
```

### 3D Array
```java
int[][][] cube = new int[2][3][4];

// Initialize
for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 4; k++) {
            cube[i][j][k] = i + j + k;
        }
    }
}
```

---

## 9. Array Operations

### Finding Maximum Element
```java
int[] arr = {3, 7, 2, 9, 1, 5};
int max = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}
System.out.println("Maximum: " + max);

// Using Stream
int max2 = Arrays.stream(arr).max().getAsInt();
```

### Finding Minimum Element
```java
int[] arr = {3, 7, 2, 9, 1, 5};
int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}
System.out.println("Minimum: " + min);

// Using Stream
int min2 = Arrays.stream(arr).min().getAsInt();
```

### Sum of Array Elements
```java
int[] arr = {1, 2, 3, 4, 5};
int sum = 0;

for (int num : arr) {
    sum += num;
}
System.out.println("Sum: " + sum);

// Using Stream
int sum2 = Arrays.stream(arr).sum();
```

### Average of Array Elements
```java
int[] arr = {1, 2, 3, 4, 5};
double sum = 0;

for (int num : arr) {
    sum += num;
}
double average = sum / arr.length;
System.out.println("Average: " + average);

// Using Stream
double avg2 = Arrays.stream(arr).average().getAsDouble();
```

### Searching an Element (Linear Search)
```java
int[] arr = {3, 7, 2, 9, 1, 5};
int target = 9;
int index = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        index = i;
        break;
    }
}

if (index != -1) {
    System.out.println("Found at index: " + index);
} else {
    System.out.println("Not found");
}
```

### Reversing an Array
```java
int[] arr = {1, 2, 3, 4, 5};
int start = 0;
int end = arr.length - 1;

while (start < end) {
    // Swap
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    
    start++;
    end--;
}

System.out.println(Arrays.toString(arr));  // [5, 4, 3, 2, 1]
```

### Copying an Array
```java
// Method 1: Manual copy
int[] original = {1, 2, 3, 4, 5};
int[] copy = new int[original.length];

for (int i = 0; i < original.length; i++) {
    copy[i] = original[i];
}

// Method 2: Arrays.copyOf()
int[] copy2 = Arrays.copyOf(original, original.length);

// Method 3: System.arraycopy()
int[] copy3 = new int[original.length];
System.arraycopy(original, 0, copy3, 0, original.length);

// Method 4: clone()
int[] copy4 = original.clone();
```

### Removing Duplicates
```java
int[] arr = {1, 2, 2, 3, 4, 4, 5};
int[] temp = new int[arr.length];
int j = 0;

Arrays.sort(arr);  // Sort first

for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] != arr[i + 1]) {
        temp[j++] = arr[i];
    }
}
temp[j++] = arr[arr.length - 1];

int[] result = Arrays.copyOf(temp, j);
System.out.println(Arrays.toString(result));  // [1, 2, 3, 4, 5]
```

### Merging Two Arrays
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {4, 5, 6};
int[] merged = new int[arr1.length + arr2.length];

System.arraycopy(arr1, 0, merged, 0, arr1.length);
System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

System.out.println(Arrays.toString(merged));  // [1, 2, 3, 4, 5, 6]
```

### Rotating an Array
```java
// Rotate right by 2 positions
int[] arr = {1, 2, 3, 4, 5};
int k = 2;  // rotation count
int n = arr.length;

// Create temp array
int[] temp = new int[n];

for (int i = 0; i < n; i++) {
    temp[(i + k) % n] = arr[i];
}

arr = temp;
System.out.println(Arrays.toString(arr));  // [4, 5, 1, 2, 3]
```

### Checking if Array is Sorted
```java
int[] arr = {1, 2, 3, 4, 5};
boolean isSorted = true;

for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1]) {
        isSorted = false;
        break;
    }
}

System.out.println("Is Sorted: " + isSorted);
```

### Frequency of Elements
```java
int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

for (int i = 0; i < arr.length; i++) {
    int count = 1;
    
    if (arr[i] != -1) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                count++;
                arr[j] = -1;  // Mark as counted
            }
        }
        System.out.println(arr[i] + " occurs " + count + " times");
    }
}
```

---

## 10. Common Array Problems

### 1. Second Largest Element
```java
public static int findSecondLargest(int[] arr) {
    if (arr.length < 2) return -1;
    
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    for (int num : arr) {
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num > secondLargest && num != largest) {
            secondLargest = num;
        }
    }
    
    return secondLargest;
}
```

### 2. Move Zeros to End
```java
public static void moveZerosToEnd(int[] arr) {
    int count = 0;
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[count++] = arr[i];
        }
    }
    
    while (count < arr.length) {
        arr[count++] = 0;
    }
}
```

### 3. Find Missing Number (1 to n)
```java
public static int findMissingNumber(int[] arr, int n) {
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    
    for (int num : arr) {
        actualSum += num;
    }
    
    return expectedSum - actualSum;
}
```

### 4. Kadane's Algorithm (Maximum Subarray Sum)
```java
public static int maxSubarraySum(int[] arr) {
    int maxSum = arr[0];
    int currentSum = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
        currentSum = Math.max(arr[i], currentSum + arr[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}
```

### 5. Two Sum Problem
```java
import java.util.HashMap;

public static int[] twoSum(int[] arr, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
        int complement = target - arr[i];
        
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        
        map.put(arr[i], i);
    }
    
    return new int[]{-1, -1};
}
```

### 6. Dutch National Flag (Sort 0s, 1s, 2s)
```java
public static void sort012(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    
    while (mid <= high) {
        if (arr[mid] == 0) {
            swap(arr, low, mid);
            low++;
            mid++;
        } else if (arr[mid] == 1) {
            mid++;
        } else {
            swap(arr, mid, high);
            high--;
        }
    }
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

---

## 11. Array vs ArrayList

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed | Dynamic (resizable) |
| Type | Primitive + Objects | Only Objects |
| Performance | Faster | Slightly slower |
| Memory | Less memory overhead | More memory overhead |
| Declaration | `int[] arr = new int[5];` | `ArrayList<Integer> list = new ArrayList<>();` |
| Add Element | `arr[0] = 10;` | `list.add(10);` |
| Remove | Not directly possible | `list.remove(index);` |
| Length/Size | `arr.length` | `list.size()` |

### Example Comparison
```java
// Array
int[] arr = new int[5];
arr[0] = 10;
int length = arr.length;

// ArrayList
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.remove(0);
int size = list.size();
```

---

## 12. Important Points & Best Practices

### Key Points
1. **Arrays are objects** in Java
2. **Index starts from 0**
3. **Size is fixed** after creation
4. **Default values**: 0 for numeric, false for boolean, null for objects
5. **ArrayIndexOutOfBoundsException** occurs when accessing invalid index
6. **Arrays are stored in heap memory**
7. **Array variables are references**

### Reference vs Value
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;  // arr2 points to same array

arr2[0] = 100;
System.out.println(arr1[0]);  // 100 (both point to same array)

// To create independent copy
int[] arr3 = arr1.clone();
```

### Best Practices
```java
// 1. Always check length before accessing
if (index >= 0 && index < arr.length) {
    System.out.println(arr[index]);
}

// 2. Use enhanced for loop when you don't need index
for (int num : numbers) {
    System.out.println(num);
}

// 3. Use Arrays.toString() for printing
System.out.println(Arrays.toString(arr));

// 4. Use meaningful names
int[] studentScores = new int[50];  // Good
int[] arr = new int[50];            // Bad

// 5. Use constants for array size
final int MAX_STUDENTS = 50;
int[] scores = new int[MAX_STUDENTS];
```

### Common Mistakes to Avoid
```java
// 1. Don't forget to initialize
int[] arr;
// arr[0] = 10;  // Error: arr is not initialized

// 2. Don't access beyond length
int[] arr = new int[5];
// arr[5] = 10;  // ArrayIndexOutOfBoundsException

// 3. Don't compare arrays with ==
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
// if (arr1 == arr2)  // Wrong! Compares references
if (Arrays.equals(arr1, arr2))  // Correct!

// 4. Don't modify array while iterating (if using ArrayList)
```

---

## Complete Example Program

```java
import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // 1. Declaration and Initialization
        int[] numbers = {5, 2, 8, 1, 9, 3, 7};
        
        System.out.println("Original Array: " + Arrays.toString(numbers));
        
        // 2. Length
        System.out.println("Length: " + numbers.length);
        
        // 3. Accessing elements
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);
        
        // 4. Sorting
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));
        
        // 5. Binary Search
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("Index of 7: " + index);
        
        // 6. Sum and Average
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double) sum / numbers.length);
        
        // 7. Finding Max and Min
        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Max: " + max + ", Min: " + min);
        
        // 8. Copy array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy: " + Arrays.toString(copy));
        
        // 9. Fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 10);
        System.out.println("Filled: " + Arrays.toString(filled));
        
        // 10. 2D Array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
```

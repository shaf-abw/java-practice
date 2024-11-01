package com.shaf.practice.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class StreamApiPractice {

    private static void averageOfIntList(List<Integer> nums) {

        double average = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("1) Average value of the said numbers: " + average);
    }

    private static void uppercaseOfStringList(List<String> colors) {

        List<String> uppercaseStrings = colors.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("2) Uppercase Strings: " + uppercaseStrings);
    }

    private static void lowercaseOfStringList(List<String> colors) {

        List<String> lowercaseStrings = colors.stream()
                .map(String::toLowerCase)
                .toList();

        System.out.println("3) Lowercase Strings: " + lowercaseStrings);
    }

    private static void sumOfEvens(List<Integer> nums) {

        int sumOfEvens = nums.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("4) Sum of even numbers: " + sumOfEvens);
    }

    private static void sumOfOdds(List<Integer> nums) {

        int sumOfOdds = nums.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("5) Sum of odd numbers: " + sumOfOdds);
    }

    private static void removeDuplicatesIntList(List<Integer> nums) {

        List<Integer> distinctNumbers = nums.stream()
                .distinct()
                .toList();

        System.out.println("6) After removing duplicates from the said list: " + distinctNumbers);
    }

    private static void countNumOfColorsStartsWithChar(List<String> colors, char startingLetter) {

        long count = colors.stream()
                .map(String::toUpperCase)
                .filter(c -> c.startsWith(String.valueOf(startingLetter)))
                .count();

        System.out.println("7) Number of colors starting with '" + startingLetter + "': " + count);
    }

    private static void ascendingOrderOfStringList(List<String> colors) {

        List<String> ascendingOrder = colors.stream()
                .sorted().toList();

        System.out.println("8) Sorted in Ascending Order: " + ascendingOrder);
    }

    private static void descendOrderOfStringList(List<String> colors) {

        List<String> descendingOrder = colors.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("9) Sorted in Descending Order: " + descendingOrder);
    }

    private static void descendOrderOfString(String str) {

        List<String> descendingOrder = Arrays.stream(str.split(" "))
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("10) Sorted in Descending Order From String: " + descendingOrder);
    }

    private static void maxOfIntList(List<Integer> nums) {

        int max_val = nums.stream()
                .max(Integer::compare)
                .orElse(0);

        System.out.println("11) Maximum value of the said list: " + max_val);
    }

    private static void minOfIntList(List<Integer> nums) {

        int min_val = nums.stream()
                .min(Integer::compare)
                .orElse(0);

        System.out.println("12) Minimum value of the said list: " + min_val);
    }

    private static void secondSmallestOfIntList(List<Integer> nums) {

        int secondSmallest = nums.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(0);

        System.out.println("13) Second smallest element: " + secondSmallest);
    }

    private static void secondLargestOfIntList(List<Integer> nums) {

        int secondLargest = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);

        System.out.println("14) Second largest element: " + secondLargest);
    }

    private static String convertString(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(i -> {
                    char c = str.charAt(i);
                    return i % 2 == 0 ? Character.toLowerCase(c) : Character.toUpperCase(c);
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static void convert(String str) {
        String convertedString = Arrays.stream(str.split(" "))
                .map(StreamApiPractice::convertString)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(" "));

        System.out.println("15) Converted String List: " + convertedString);

    }

    private static void removeDuplicateFromString(String str) {

        String removedString = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println("16) After Removed duplicate from string: " + removedString);
    }

    private static void employeeSortByAgeAndSalary(List<Employee> employees) {

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getSalary))
                .toList();

        System.out.println("17) Employee After Sorted by Age and Salary:");
        sortedEmployees.forEach(System.out::println);
    }

    private static void mergeIntArrays(int[] i, int[] j) {

            int[] mergedIntArray = IntStream.concat(Arrays.stream(i), Arrays.stream(j))
                .distinct()
                .sorted()
                .toArray();

        System.out.print("18) Merged Int Array : ");
        Arrays.stream(mergedIntArray).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    private static void mergeStringArray(String[] a, String[] b) {

        String[] mergedStringArray = Stream.concat(Arrays.stream(a), Arrays.stream(b))
                .distinct()
                .sorted()
                .toArray(String[]::new);

        System.out.print("19) Merged String Array : ");
        Arrays.stream(mergedStringArray).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static void find3rdHighestMark(List<Student> students) {

        Student student = students.stream()
                .sorted(Comparator.comparing(Student::getMark).reversed())
                .skip(2)
                .findFirst().orElse(null);

        if (student != null) {
            System.out.println("20) Third Highest Mark is : " + student.getMark());
        } else {
            System.out.println("Data not found");
        }

    }

    private static void reverseString(String str) {

        String reversedString = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("21) Reversed String: " + reversedString);
    }

    private static void numOfGendersCount(List<Employee> employees) {

        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println("22) Male Count: " + genderCount.getOrDefault("MALE", 0L));
        System.out.println("Female Count: " + genderCount.getOrDefault("FEMALE", 0L));
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        List<Integer> nums1 = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15, 10, 22);
        String str = "I am an developer";
        String shaf = "Shafeeque";

        // Stream Sorting
        int[] i = {9, 7, 10, 6};
        int[] j = {15, 8, 9, 7};
        String[] a = {"apple", "banana", "cherry"};
        String[] b = {"banana", "date", "apple"};

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Student 1", 350.50));
        students.add(new Student(1, "Student 2", 310.10));
        students.add(new Student(1, "Student 3", 444.50));
        students.add(new Student(1, "Student 4", 250.40));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30, "MALE", 50000, "IT"));
        employees.add(new Employee("Jane", 25, "FEMALE", 60000, "IT"));
        employees.add(new Employee("Jake", 30, "MALE", 45000, "HR"));
        employees.add(new Employee("Jill", 25, "FEMALE", 65000, "FINANCE"));

        averageOfIntList(nums);
        uppercaseOfStringList(colors);
        lowercaseOfStringList(colors);
        sumOfEvens(nums);
        sumOfOdds(nums);
        removeDuplicatesIntList(nums1);
        countNumOfColorsStartsWithChar(colors, 'B'); // starting as 'Y'
        ascendingOrderOfStringList(colors);
        descendOrderOfStringList(colors);
        descendOrderOfString(str);
        maxOfIntList(nums);
        minOfIntList(nums);
        secondSmallestOfIntList(nums);
        secondLargestOfIntList(nums);

        convert(str);

        removeDuplicateFromString(shaf);
        employeeSortByAgeAndSalary(employees);
        getHighestPaidEmpByEachDept(employees);

        mergeIntArrays(i, j);
        mergeStringArray(a, b);

        find3rdHighestMark(students);
        reverseString(shaf);
        numOfGendersCount(employees);
        findVowelsInString(shaf);
        int[] arr = {2, 5, 6, 8, 5, 7};
        int target = 9;

        // Method to find two indices
        findTwoSum(arr, target);

        int n;
        int[] x,y,z;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the each input array length");
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        z = new int[n];

        System.out.println("Enter the input 1");
        for (int w=0;w<n;w++) {
            System.out.println("Array of "+w);
            x[w] = sc.nextInt();
        }

        System.out.println("Enter the input 2");
        for (int w=0;w<n;w++) {
            System.out.println("Array of "+w);
            y[w] = sc.nextInt();
        }

        System.out.println("Enter the input 3");
        for (int w=0;w<n;w++) {
            System.out.println("Array of "+w);
            z[w] = sc.nextInt();
        }

        System.out.println("X --> ");
        Arrays.stream(x).forEach(System.out::print);
        System.out.println("Y --> ");
        Arrays.stream(y).forEach(System.out::print);
        System.out.println("Z --> ");
        Arrays.stream(z).forEach(System.out::print);
    }

    private static void getHighestPaidEmpByEachDept(List<Employee> employees) {

        Map<String, Optional<Employee>> highestPaidEmployees = new HashMap<>();

        highestPaidEmployees = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));


        highestPaidEmployees.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.orElse(null))
        );
    }

    private static void findTwoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {};

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                result = new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        if (result != null) {
            System.out.println("Output = " + result[0] + "," + result[1]);
        } else {
            System.out.println("No solution found.");
        }

    }

    private static void findVowelsInString(String str) {

        List<Character> vowelsList = str.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".indexOf(c) != -1)
                .toList();

        System.out.println("Vowels List : " + vowelsList);
    }

}

class Employee {
    private String name;
    private int age;
    private String gender;
    private double salary;
    private String dept;

    // Constructor, getters, and toString method

    public Employee(String name, int age, String gender, double salary, String dept) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() { return dept; };

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", gender=" + gender + ", salary=" + salary + ", dept=" + dept + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, salary);
    }
}

class Student {

    int id;
    String name;
    double mark;

    public Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

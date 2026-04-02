// Author: Alexander Phipps
// Course: CS2
// Semester: Spring 2025

import java.util.*;

public class NumClassCombos 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Read in # of students on Line 1
        int n = Integer.parseInt(scanner.nextLine());

        // HashMap to store courses, and students enrolled in each
        HashMap<String, HashSet<String>> courseToStudents = new HashMap<>();

        // Parse student data (courses and name)
        for (int i = 0; i < n; i++) 
        {
            String[] input = scanner.nextLine().split(" ");
            String student = input[0];

            for (int j = 1; j < input.length; j++) 
            {
                String course = input[j];
                
                // Add the student to the set of students in this course
                courseToStudents.putIfAbsent(course, new HashSet<>());
                courseToStudents.get(course).add(student);
            }

        }

        // Set to store unique student pairs with 1 or more course shared
        HashSet<String> studentPairs = new HashSet<>();

        // Find student pairs based on shared courses
        for (HashSet<String> students : courseToStudents.values()) 
        {
            List<String> studentList = new ArrayList<>(students);
            for (int i = 0; i < studentList.size(); i++) 
            {
                for (int j = i + 1; j < studentList.size(); j++) 
                {
                    String student1 = studentList.get(i);
                    String student2 = studentList.get(j);

                    // Make sure the pair is always in lexicographical order
                    String pair;

                    if (student1.compareTo(student2) < 0)
                    {
                        pair = student1 + "," + student2;
                    } 
                    
                    else {
                        pair = student2 + "," + student1;
                    }

                    studentPairs.add(pair);
                }
            }
        }

        // Output total number of pairs
        System.out.println(studentPairs.size());
    }
}

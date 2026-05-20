package Challenge19_Comparators;

import java.util.*;

class Student implements Comparable<Student> {
    private static int LAST_ID = 1;
    private final int id;
    private final String name;
    private final int year;
    private final String course;

    Student(String name, int year, String course) {
        this.id = LAST_ID++;
        this.name = name;
        this.year = year;
        this.course = course;
    }

    public int getId() { return id; }
    public String getCourse() { return course; }
    public int getYear() { return year; }

    public boolean matchFieldValue(String field, String value) {
        return switch (field) {
            case "course" -> course.equalsIgnoreCase(value);
            case "year" -> Integer.toString(year).equals(value);
            default -> false;
        };
    }

    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }

    public String toString() {
        return id + " " + name + " " + course + " " + year;
    }
}

class ScoredStudent extends Student {
    private final double percent;

    ScoredStudent(String name, int year, String course, double percent) {
        super(name, year, course);
        this.percent = percent;
    }

    public double getPercent() { return percent; }

    public boolean matchFieldValue(String field, String value) {
        if (field.equals("percent")) {
            return percent <= Double.parseDouble(value);
        }
        return super.matchFieldValue(field, value);
    }

    public String toString() {
        return super.toString() + " " + percent;
    }
}

class QueryList<T extends Student> extends ArrayList<T> {

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (T item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}

class CourseComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getCourse().compareTo(s2.getCourse());
    }
}

class PercentComparator implements Comparator<ScoredStudent> {
    public int compare(ScoredStudent s1, ScoredStudent s2) {
        return Double.compare(s1.getPercent(), s2.getPercent());
    }
}

class Main {
    public static void main(String[] args) {
        QueryList<ScoredStudent> students = new QueryList<>();
        Random random = new Random();

        String[] courses = {"Java", "Python", "C#", "Math"};

        for (int i = 0; i < 25; i++) {
            students.add(new ScoredStudent(
                    "Student" + i,
                    random.nextInt(1, 4),
                    courses[random.nextInt(courses.length)],
                    random.nextDouble() * 100
            ));
        }

        QueryList<ScoredStudent> filtered = students.getMatches("percent", "50");

        Collections.sort(filtered);
        filtered.forEach(System.out::println);

        filtered.sort(new PercentComparator());
        filtered.forEach(System.out::println);
    }
}
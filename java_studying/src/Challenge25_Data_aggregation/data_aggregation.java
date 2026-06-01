package Challenge25_Data_aggregation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class data_aggregation {

    public static void main(String[] args) {

        Course pbc = new Course("PBC", "Python Bootcamp", 50);
        Course jac = new Course("JAC", "Java Advanced Class", 100);
        Course games = new Course("GAME", "Creating Games in Java");

        List<Course> courses = List.of(pbc, jac);

        Supplier<Student> studentSupplier = () -> Student.getRandomStudent(courses);

        List<Student> students = Stream.generate(studentSupplier)
                .limit(5000)
                .toList();

        double averagePercentComplete = students.stream()
                .map(s -> s.getPercentComplete("JAC"))
                .reduce(0.0, Double::sum) / students.size();

        System.out.println("Average percent complete for JAC: " + averagePercentComplete);

        double targetPercent = averagePercentComplete * 1.25;

        List<Student> selectedStudents = students.stream()
                .filter(s -> s.getPercentComplete("JAC") > targetPercent)
                .filter(s -> s.getMonthsSinceActive() <= 12)
                .sorted(Comparator.comparing(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                .toList();

        selectedStudents.forEach(s -> s.addCourse(games));

        selectedStudents.forEach(System.out::println);
    }
}

class Course {

    private final String courseCode;
    private final String title;
    private final int lectureCount;

    public Course(String courseCode, String title) {
        this(courseCode, title, 40);
    }

    public Course(String courseCode, String title, int lectureCount) {
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount = lectureCount;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getLectureCount() {
        return lectureCount;
    }

    @Override
    public String toString() {
        return courseCode + " " + title + " " + lectureCount;
    }
}

class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private final String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.engagementType = engagementType;
        this.lastLecture = 0;
        this.lastActivityDate = enrollmentDate;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }

    public int getMonthsSinceActive() {
        Period period = Period.between(lastActivityDate, LocalDate.now());
        return period.getYears() * 12 + period.getMonths();
    }

    public double getPercentComplete() {
        return lastLecture * 100.0 / course.getLectureCount();
    }

    public void watchLecture(int lectureNumber, LocalDate activityDate) {
        lastLecture = Math.min(lectureNumber, course.getLectureCount());
        lastActivityDate = activityDate;
    }
}

class Student {

    private static final Random random = new Random();
    private static int lastId = 1;

    private final int studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageAtEnrollment;
    private final String gender;
    private final boolean hasProgrammingExperience;
    private final Map<String, CourseEngagement> courseEngagements;

    public Student(String countryCode, int yearEnrolled, int ageAtEnrollment,
                   String gender, boolean hasProgrammingExperience, List<Course> courses) {

        this.studentId = lastId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageAtEnrollment = ageAtEnrollment;
        this.gender = gender;
        this.hasProgrammingExperience = hasProgrammingExperience;
        this.courseEngagements = new HashMap<>();

        for (Course course : courses) {
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeAtEnrollment() {
        return ageAtEnrollment;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return hasProgrammingExperience;
    }

    public Map<String, CourseEngagement> getCourseEngagements() {
        return courseEngagements;
    }

    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge() {
        return ageAtEnrollment + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode) {
        return courseEngagements.get(courseCode).getMonthsSinceActive();
    }

    public int getMonthsSinceActive() {
        return courseEngagements.values()
                .stream()
                .mapToInt(CourseEngagement::getMonthsSinceActive)
                .min()
                .orElse(0);
    }

    public double getPercentComplete(String courseCode) {
        return courseEngagements.get(courseCode).getPercentComplete();
    }

    public void addCourse(Course course) {
        addCourse(course, LocalDate.now());
    }

    public void addCourse(Course course, LocalDate enrollmentDate) {
        courseEngagements.put(course.getCourseCode(),
                new CourseEngagement(course, enrollmentDate, "Lecture"));
    }

    public void watchLecture(String courseCode, int lectureNumber, int activityYear, int activityMonth) {
        CourseEngagement engagement = courseEngagements.get(courseCode);

        if (engagement != null) {
            engagement.watchLecture(lectureNumber, LocalDate.of(activityYear, activityMonth, 1));
        }
    }

    public static Student getRandomStudent(List<Course> courses) {

        String[] countries = {"EE", "FI", "LV", "LT", "UA", "PL", "DE", "FR", "ES", "IT"};
        String[] genders = {"M", "F"};

        String country = countries[random.nextInt(countries.length)];
        String gender = genders[random.nextInt(genders.length)];
        int currentYear = LocalDate.now().getYear();
        int yearEnrolled = currentYear - random.nextInt(12);
        int ageAtEnrollment = 18 + random.nextInt(45);
        boolean experience = random.nextBoolean();

        Student student = new Student(country, yearEnrolled, ageAtEnrollment, gender, experience, courses);

        for (Course course : courses) {
            int minLecture = Math.min(30, course.getLectureCount());
            int lecture = minLecture + random.nextInt(course.getLectureCount() - minLecture + 1);
            int activityYear = yearEnrolled + random.nextInt(currentYear - yearEnrolled + 1);
            int activityMonth = 1 + random.nextInt(12);

            if (activityYear == currentYear && activityMonth > LocalDate.now().getMonthValue()) {
                activityMonth = LocalDate.now().getMonthValue();
            }

            student.watchLecture(course.getCourseCode(), lecture, activityYear, activityMonth);
        }

        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", countryCode='" + countryCode + '\'' +
                ", yearEnrolled=" + yearEnrolled +
                ", age=" + getAge() +
                ", gender='" + gender + '\'' +
                ", hasProgrammingExperience=" + hasProgrammingExperience +
                ", monthsSinceActive=" + getMonthsSinceActive() +
                ", courses=" + courseEngagements.keySet() +
                '}';
    }
}
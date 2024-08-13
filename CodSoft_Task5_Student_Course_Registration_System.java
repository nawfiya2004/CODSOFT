import java.util.*;
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getEnrolledStudents() {
        return enrolledStudents;
    }
    public String getSchedule() {
        return schedule;
    }
    public boolean registerStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        }
        return false;
    }
    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }
    public int getAvailableSlots() {
        return capacity - enrolledStudents;
    }
}
class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
    public boolean registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }
    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
        }
    }
    public boolean isCourseRegistered(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }
}
class CourseDatabase {
    private Map<String, Course> courses;
    public CourseDatabase() {
        this.courses = new HashMap<>();
    }
    public void addCourse(Course course) {
        courses.put(course.getCourseCode(), course);
    }
    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }
    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses.values()) {
            System.out.println(course.getCourseCode() + ": " + course.getTitle() + " (" + course.getAvailableSlots() + " slots available)");
        }
    }
}
class StudentDatabase {
    private Map<String, Student> students;

    public StudentDatabase() {
        this.students = new HashMap<>();
    }
    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }
}
class CourseManagementSystem {
    private CourseDatabase courseDatabase;
    private StudentDatabase studentDatabase;
    public CourseManagementSystem() {
        this.courseDatabase = new CourseDatabase();
        this.studentDatabase = new StudentDatabase();
    }
    public CourseDatabase getCourseDatabase() {
        return courseDatabase;
    }
    public StudentDatabase getStudentDatabase() {
        return studentDatabase;
    }
    public void registerStudentForCourse(String studentId, String courseCode) {
        Student student = studentDatabase.getStudent(studentId);
        Course course = courseDatabase.getCourse(courseCode);
        if (student != null && course != null) {
            if (student.registerCourse(course)) {
                System.out.println(student.getName() + " has been registered for " + course.getTitle());
            } else {
                System.out.println("Registration failed: No available slots.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }
    public void dropCourse(String studentId, String courseCode) {
        Student student = studentDatabase.getStudent(studentId);
        if (student != null) {
            if (student.isCourseRegistered(courseCode)) {
                Course course = courseDatabase.getCourse(courseCode);
                student.dropCourse(course);
                System.out.println(student.getName() + " has dropped " + course.getTitle());
            } else {
                System.out.println("You have not registered for this course.");
            }
        } else {
            System.out.println("Invalid student ID.");
        }
    }
}
public class CodSoft_Task5_Student_Course_Registration_System {
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        cms.getCourseDatabase().addCourse(new Course("CS101", "Intro to Computer Science", "Basic concepts of CS", 30, "MWF 9-10"));
        cms.getCourseDatabase().addCourse(new Course("CS102", "Data Structures", "In-depth study of data structures", 25, "TTh 11-12"));
        cms.getStudentDatabase().addStudent(new Student("S123", "Nawfiya"));
        cms.getStudentDatabase().addStudent(new Student("S124", "Nasi"));
        cms.getStudentDatabase().addStudent(new Student("S125", "Jesi"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Display Available Courses");
        System.out.println("2. Register for a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cms.getCourseDatabase().displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter the course code to register: ");
                    String courseCodeToRegister = scanner.next();
                    cms.registerStudentForCourse(studentId, courseCodeToRegister);
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    String studentIdForDrop = scanner.next();
                    System.out.print("Enter the course code to drop: ");
                    String courseCodeToDrop = scanner.next();
                    cms.dropCourse(studentIdForDrop, courseCodeToDrop);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

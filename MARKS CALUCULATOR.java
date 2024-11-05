import java.util.Scanner;

class GradeCalculator {
    
    public static void main(String[] args) {
        int t_marks;
        float avg_marks, percentage;
        String grade = "";  // Declare grade outside of if-else blocks

        Scanner scanner = new Scanner(System.in);

        // Taking marks input
        System.out.println("ENTER CN MARKS :-");
        int cn = scanner.nextInt();
        System.out.println("ENTER DAA MARKS :-");
        int daa = scanner.nextInt();
        System.out.println("ENTER PPL MARKS :-");
        int ppl = scanner.nextInt();
        System.out.println("ENTER DEVOPS MARKS :-");
        int devops = scanner.nextInt();
        System.out.println("ENTER DD MARKS :-");
        int dd = scanner.nextInt();

        // Calculating total, average, and percentage
        t_marks = cn + daa + ppl + devops + dd;
        avg_marks = t_marks / 5f;  // Use float division
        percentage = (t_marks / 500f) * 100;  // Corrected to get float result

        // Determining grade
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B+";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C+";
        } else if (percentage >= 40) {
            grade = "C";
        } else {
            grade = "FAIL";
        }
        
        // Display the grade
        System.out.println("GRADE = " + grade);

        // Menu for additional services
        System.out.println("SELECT A NUMBER TO GET THE SERVICES");
        System.out.println("1. TOTAL MARKS\n2. AVERAGE MARKS\n3. PERCENTAGE\n4. GRADE");
        System.out.print("ENTER YOUR CHOICE :- ");
        int choice = scanner.nextInt();

        // Switch statement to display selected information
        switch(choice) {
            case 1:
                System.out.println("TOTAL MARKS = " + t_marks);
                break;
            case 2:
                System.out.println("AVERAGE MARKS = " + avg_marks);
                break;
            case 3:
                System.out.println("PERCENTAGE = " + percentage + "%");
                break;
            case 4:
                System.out.println("GRADE = " + grade);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();
        
    } 
}

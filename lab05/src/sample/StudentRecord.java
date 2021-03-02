package sample;

public class StudentRecord {

    public String student_ID;
    public float assignments;
    public float midterm;
    public float final_exam;
    public double final_mark;
    public char letter_grade;

    public StudentRecord(String student_ID, float assignments, float midterm, float final_exam) {
        this.student_ID = student_ID;
        this.assignments = assignments;
        this.midterm = midterm;
        this.final_exam = final_exam;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public float get_Midterm() {
        return midterm;
    }

    public float get_Assignments() {
        return assignments;
    }

    public float get_FinalExam() {
        return final_exam;
    }

    public double get_FinalMark() {
        final_mark = ((assignments * 0.2) + (midterm * 0.3) + (final_exam * 0.5));
        return final_mark;
    }

    public char getLetterGrade() {
        if (final_mark <= 50) {
            letter_grade = 'F';
            return letter_grade;
        } else if (final_mark <= 60) {
            letter_grade = 'D';
            return letter_grade;
        } else if (final_mark <= 70) {
            letter_grade = 'C';
            return letter_grade;
        } else if (final_mark <= 80) {
            letter_grade = 'B';
            return letter_grade;
        } else {
            letter_grade = 'A';
            return letter_grade;
        }
    }

}

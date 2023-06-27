package app.studentmanagement.model;

public class Student extends Person implements StudentImp{
    private long studentId;
    private double mathScore;
    private double literatureScore;
    private double languageScore;


    public Student(long id, String fullName, String birthDay, String homeTown, long studentId) {
        super(id, fullName, birthDay, homeTown);
        this.studentId = studentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(double literatureScore) {
        this.literatureScore = literatureScore;
    }

    public double getLanguageScore() {
        return languageScore;
    }

    public void setLanguageScore(double languageScore) {
        this.languageScore = languageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", mathScore=" + mathScore +
               ", literatureScore=" + literatureScore +
               ", languageScore=" + languageScore +
               '}';
    }

    @Override
    public double getAvgScore(double mathScore, double literatureScore, double languageScore) {
        return (mathScore + literatureScore + languageScore) / 3.0;
    }

    @Override
    public String getOverall(double avgScore) {
        if(avgScore >= 8.0){
            return "A";
        }
        if(avgScore >= 6.0){
            return "B";
        }
        return "C";
    }
}

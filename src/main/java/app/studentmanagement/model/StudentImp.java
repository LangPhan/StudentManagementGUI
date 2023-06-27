package app.studentmanagement.model;

public interface StudentImp {
    double getAvgScore(double mathScore, double literatureScore, double languageScore);
    String getOverall(double avgScore);
}

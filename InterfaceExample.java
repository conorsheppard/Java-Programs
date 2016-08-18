public interface InterfaceExample {
    void setHomeTeam(String name);
    String getHomeTeam();
}

//Filename: Sports.java
/*
public interface Sports {
    public void setHomeTeam(String name);
    public void setVisitingTeam(String name);
}
*/

//Filename: Football.java
/*
public interface Football extends Sports {
    public void homeTeamScored(int points);
    public void visitingTeamScored(int points);
    public void endOfQuarter(int quarter);
}
*/

//Filename: Hockey.java
/*
public interface Hockey extends Sports {
    public void homeGoalScored();
    public void visitingGoalScored();
    public void endOfPeriod(int period);
    public void overtimePeriod(int ot);
}
*/
package by.exadel.todo.model;

public enum Period {
    TODAY, THIS_WEEK, LATER;

public Period getPeriod(String string){
    Period period=null;
    if (string.compareTo("today")==0){
        period = Period.TODAY;
    }
    if (string.compareTo("later")==0){
        period = Period.LATER;
    }
    if (string.compareTo("this week")==0){
        period = Period.THIS_WEEK;
    }
    return period;
}


}

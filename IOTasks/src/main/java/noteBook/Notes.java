package noteBook;

import java.util.Date;
import java.util.GregorianCalendar;

public class Notes {
    private String name;
    private String description;
    private Priority priority;
    private Date createDate;
    private Date endGameDate;
    private String executor;
    private boolean isComplete;


    public Notes(String name) {
        this.name = name;
        this.createDate = new Date();
        this.isComplete = false;


    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n"
                + "Description: " + this.description + "\n"
                + "Priority: " + this.priority.toString() + "\n"
                + "Create Date: " + this.createDate.toString() + "\n"
                + "EndGame Date: " + this.endGameDate.toString() + "\n"
                + "Executor: " + executor + "\n"
                + "Complete: " + isComplete + "\n" + "\n";
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getCreateDate() {
        return createDate;
    }


    public Date getEndGameDate() {
        return endGameDate;
    }

    public void setEndGameDate(int year, int month, int date) {
        this.endGameDate = new GregorianCalendar(year, month, date).getTime();
        if (this.endGameDate.before(this.createDate))
            this.endGameDate  = this.createDate;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}

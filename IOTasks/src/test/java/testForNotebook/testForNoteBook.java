package testForNotebook;

import noteBook.Notebook;
import noteBook.Notes;
import noteBook.Priority;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class testForNoteBook {


    @Test
    public void createNotebookPositive() {
        Notebook nb = new Notebook("notebook.txt");
        Assert.assertNotNull(nb);
        Assert.assertTrue(nb.getFile().exists());

    }


    @Test
    public void createNotePositive() {
        Notes note = new Notes("Task1");
        note.setDescription("do something");
        note.setExecutor("somebody");
        note.setEndGameDate(2019, Calendar.SEPTEMBER, 12);
        note.setPriority(Priority.IMPORTANT);

        Assert.assertNotNull(note);
    }


    @Test
    public void testNotebookAddNotePositive() {
        Notebook nb = new Notebook("notebook.txt");
        Notes note = new Notes("Task1");
        note.setDescription("do something");
        note.setExecutor("somebody");
        note.setEndGameDate(2019, Calendar.DECEMBER, 30);
        note.setPriority(Priority.IMPORTANT);
        nb.addNote(note);
    }

    @Test
    public void testNotebookShowNotes() {
        Notebook nb = new Notebook("notebook.txt");
        Notes note = new Notes("Task2");
        note.setDescription("do something else");
        note.setExecutor("somebody else");
        note.setEndGameDate(2018, Calendar.APRIL, 30);
        note.setPriority(Priority.NOT_IMPORTANT);
        nb.addNote(note);


        Notes note1 = new Notes("Task3");
        note1.setDescription("do something else");
        note1.setExecutor("somebody else");
        note1.setEndGameDate(2019, Calendar.MARCH, 20);
        note1.setPriority(Priority.IMPORTANT);
        nb.addNote(note1);

        nb.showNotes();
    }
}

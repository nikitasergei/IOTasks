package noteBook;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notebook implements NotebookService {
    private File file;

    public Notebook(String fileName) {
        checkFile(fileName);
    }

    public boolean addNote(Notes note) {
        checkFile(this.file.getName());
        try {
            FileWriter fileWriter = new FileWriter(this.file.getName(), true);
            fileWriter.append(note.toString());
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void showNotes() {
        try (FileReader reader = new FileReader(this.file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void checkFile(String fileName) {
        this.file = new File(fileName);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}


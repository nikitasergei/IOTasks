package calc;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Calculator implements CalcOperation {
    private File file;

    public Calculator(String fileName) {
        this.file = new File(fileName + ".txt");
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public double addition(double A, double B) {
        double res = A + B;
        try {
            FileWriter fw = new FileWriter(this.file, true);
            fw.append(new Date()
                    .toString())
                    .append("        operation:     ")
                    .append(String.valueOf(A))
                    .append(" + ")
                    .append(String.valueOf(B))
                    .append(" = ")
                    .append(String.valueOf(res))
                    .append("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public double subtraction(double A, double B) {
        double res = A - B;
        try {
            FileWriter fw = new FileWriter(this.file, true);
            fw.append(new Date()
                    .toString())
                    .append("        operation:     ")
                    .append(String.valueOf(A))
                    .append(" - ")
                    .append(String.valueOf(B))
                    .append(" = ")
                    .append(String.valueOf(res))
                    .append("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public double multiplication(double A, double B) {
        double res = A * B;
        try {
            FileWriter fw = new FileWriter(this.file, true);
            fw.append(new Date()
                    .toString())
                    .append("        operation:     ")
                    .append(String.valueOf(A))
                    .append(" * ")
                    .append(String.valueOf(B))
                    .append(" = ")
                    .append(String.valueOf(res))
                    .append("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public double division(double A, double B) {
        if (B != 0) {
            double res = A / B;
            try {
                FileWriter fw = new FileWriter(this.file, true);
                fw.append(new Date()
                        .toString())
                        .append("        operation:     ")
                        .append(String.valueOf(A))
                        .append(" / ")
                        .append(String.valueOf(B))
                        .append(" = ")
                        .append(String.valueOf(res))
                        .append("\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        } else try {
            FileWriter fw = new FileWriter(this.file, true);
            fw.append(new Date()
                    .toString())
                    .append("        operation:     ")
                    .append(" DIVIDING BY ZERO")
                    .append("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void showHistory() {
        try (FileReader reader = new FileReader(this.file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}


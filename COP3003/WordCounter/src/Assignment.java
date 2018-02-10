import java.io.FileNotFoundException;

public class Assignment {

    public static void main(String[] args) throws FileNotFoundException {
        FileStats fs=new FileStats();
        fs.wordfinder();

        fs.printFrequentWords();

    }

}
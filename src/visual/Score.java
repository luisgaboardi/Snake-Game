import java.io.File;
import java.io.IOException;

public class Score {
    public Score(){
        File file = new File("Scores");
        file.mkdir();

        File txt = new File("Scores/Scores.txt");
        try {
            txt.createNewFile();
        }catch (IOException ex){

        }
    }
}

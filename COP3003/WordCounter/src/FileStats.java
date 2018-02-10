import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

    class FileStats { private ArrayList <String> wordList;
    private HashSet <String> wordSet= new HashSet<>();
    private ArrayList <Entry<String>> entryList= new ArrayList<>();

    FileStats() {
        wordList = new ArrayList<>();
    }

    void wordfinder() throws FileNotFoundException
    {
        FileReader fr = new FileReader
                ( "/Users/aotanob/IdeaProjects/WordCounter/src/basketball" +
                        ".txt" );
        Scanner input = new Scanner( fr );
        String line;
        try{
            while((line= input.nextLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String words=st.nextToken();
                    //check any puntuations
                    words=removePunctuations(words);
                    //word to lower case
                    wordList.add(words.toLowerCase());
                    wordSet.add(words.toLowerCase());
                }
            }
        }catch(NoSuchElementException e){
            // no more lines in the file
            // no handler is necessary
        }
        //System.out.println(wordList);
        //System.out.println(wordSet);
        for (String word : wordSet) {
            int frq = Collections.frequency( wordList, word );
            Entry<String> en = new Entry<>( word, frq );
            entryList.add( en );
        }
        //System.out.println(entryList);
        Collections.sort(entryList);
        //System.out.println(entryList);
    }
    void printFrequentWords()
    {
        for(int i=0;i<4;i++){
            System.out.println(entryList.get(i).word+" appears "+
                    entryList.get(i).frequency+" time(s).");
        }

    }
    private String removePunctuations(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                res.append( c );
        }
        return res.toString();
    }
}
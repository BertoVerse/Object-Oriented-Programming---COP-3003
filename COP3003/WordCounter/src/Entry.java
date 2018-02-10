public class Entry <T> implements Comparable<Entry<T>>{
    String word;
    int frequency;
    Entry(String word, int f)
    {
        this.word=word;
        frequency=f;
    }

    @Override
    public String toString() {
        return "Entry [word=" + word + ", frequency=" + frequency +"]";
    }
    @Override
    public int compareTo(Entry<T> arg0) {

        return arg0.frequency-frequency;
    }

}
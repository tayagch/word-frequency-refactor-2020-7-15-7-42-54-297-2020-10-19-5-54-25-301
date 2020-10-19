public class WordInfos {
    private String value;
    private int count;

    public WordInfos(String word, int count){
        this.value =word;
        this.count =count;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}

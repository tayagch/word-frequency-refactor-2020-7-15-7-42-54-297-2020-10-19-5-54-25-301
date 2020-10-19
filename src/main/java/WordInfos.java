public class WordInfos {
    private String value;
    private int count;

    public WordInfos(String word, int i){
        this.value =word;
        this.count =i;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}

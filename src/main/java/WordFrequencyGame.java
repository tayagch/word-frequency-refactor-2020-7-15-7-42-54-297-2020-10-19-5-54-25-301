import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";

    public String getResult(String inputStr){
        List<WordInfos> wordInfosList = calculateWordFrequency(inputStr);

        wordInfosList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

        return joinWords(wordInfosList);
    }

    private String joinWords(List<WordInfos> wordInfosList) {
        return wordInfosList.stream()
                .map(wordInfos -> String.format("%s %d", wordInfos.getValue(), wordInfos.getWordCount()))
                .collect(Collectors.joining("\n"));
    }

    private List<WordInfos> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfos> wordInfos = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int count = Collections.frequency(words,word);
            wordInfos.add(new WordInfos(word,count));
        }
        return wordInfos;
    }
}

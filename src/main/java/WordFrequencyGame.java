import java.util.*;
import java.util.function.Function;
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
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entrySet -> new WordInfos(entrySet.getKey(),Math.toIntExact(entrySet.getValue()))).collect(Collectors.toList());
    }
}

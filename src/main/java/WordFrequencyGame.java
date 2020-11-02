import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){

        List<WordInfo> wordInfos = calculateWordFrequency(sentence).stream()
                .sorted(Comparator.comparing(WordInfo::getWordCount))
                .collect(Collectors.toList());

        return joinWords(wordInfos);
    }

    private String joinWords(List<WordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .collect(Collectors.joining("\n"));
    }

    private List<WordInfo> calculateWordFrequency(String sentence){
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entrySet -> new WordInfo(entrySet.getKey(),Math.toIntExact(entrySet.getValue())))
                .collect(Collectors.toList());
    }
}

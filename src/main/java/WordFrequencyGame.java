import java.util.*;

public class WordFrequencyGame {

    private static final String WHITE_SPACES = "\\s+";

    public String getResult(String inputStr){


        if (inputStr.split(WHITE_SPACES).length==1) {
            return inputStr + " 1";
        } else {

            try {

//                //split the input string with 1 to n pieces of spaces
//                String[] arr = inputStr.split(WHITE_SPACES);
//
//                List<WordInfos> wordInfosList = new ArrayList<>();
//                for (String s : arr) {
//                    WordInfos wordInfos = new WordInfos(s, 1);
//                    wordInfosList.add(wordInfos);
//                }
//
//                //get the map for the next step of sizing the same word
//                Map<String, List<WordInfos>> map =getListMap(wordInfosList);
//
//                List<WordInfos> list = new ArrayList<>();
//                for (Map.Entry<String, List<WordInfos>> entry : map.entrySet()){
//                    WordInfos wordInfos = new WordInfos(entry.getKey(), entry.getValue().size());
//                    list.add(wordInfos);
//                }
                List<WordInfos> wordInfosList = calculateWordFrequency(inputStr);

                wordInfosList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfos w : wordInfosList) {
                    String s = String.format("%s %d", w.getValue(), w.getWordCount());
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
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


    private Map<String,List<WordInfos>> getListMap(List<WordInfos> wordInfosList) {
        Map<String, List<WordInfos>> map = new HashMap<>();
        for (WordInfos wordInfos : wordInfosList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordInfos.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfos);
                map.put(wordInfos.getValue(), arr);
            }

            else {
                map.get(wordInfos.getValue()).add(wordInfos);
            }
        }


        return map;
    }


}

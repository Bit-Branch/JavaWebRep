package by.epam.ih.action;

import by.epam.ih.comparator.ParagraphSizeComparator;
import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.exception.ComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextAction {
    private static TextAction instance = new TextAction();

    private static final Logger LOGGER = LogManager.getLogger(TextAction.class);

    public static TextAction getInstance() { return instance; }

    TextAction() {}

    public void deleteSentences(TextComponent component, int value) throws ComponentException {
        if (component.getSentenceType() != SentenceType.TEXT) {
            LOGGER.error("Argument " + component + " is not a text type");
            throw new ComponentException();
        }
        List<Composite> paragraphs = (List<Composite>) component.getChild();

        for (TextComponent paragraph : paragraphs) {
            List<Composite> sentences = (List<Composite>) paragraph.getChild();
            for (Iterator<Composite> iterator = sentences.iterator(); iterator.hasNext(); )
            {
                TextComponent sentence = iterator.next();
                if (((List<Composite>)sentence.getChild()).size() < value) {
                    LOGGER.info("Removing sentence: " + sentence);
                    iterator.remove();
                }
            }
        }
    }

    public void sortParagraphs(TextComponent component) throws ComponentException {
        if (component.getSentenceType() != SentenceType.TEXT) {
            LOGGER.error("Argument " + component + " is not a text type");
            throw new ComponentException();
        }
        List<Composite> paragraphs = (List<Composite>) component.getChild();
        paragraphs.sort(new ParagraphSizeComparator());
        LOGGER.info("Paragraphs in " + component + " sorted");
    }

    private static Map<String, Integer> getFilterOutput(Map<String, Integer> map, int filter) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > filter) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public long calculateIdenticalWords(TextComponent component) throws ComponentException {
        if (component.getSentenceType() != SentenceType.TEXT) {
            LOGGER.error("Argument " + component + " is not a text type");
            throw new ComponentException();
        }
        Map<String, Integer> identicalWords = new HashMap<>();
        List<Composite> paragraphs = (List<Composite>) component.getChild();
        for (TextComponent paragraph : paragraphs) {
            List<Composite> sentences = (List<Composite>) paragraph.getChild();

            for (TextComponent sentence : sentences) {
                List<Composite> words = (List<Composite>) sentence.getChild();

                for (TextComponent word : words) {
                    String strWord;
                    StringBuilder builderWord = new StringBuilder();

                    for (TextComponent element : (List<Composite>) word.getChild()) {
                        if (element.getSentenceType() != SentenceType.PUNCTUATION) {
                            builderWord.append(element);
                        }
                    }
                    strWord = builderWord.toString();

                    if (identicalWords.containsKey(strWord)) {
                        identicalWords.put(strWord, identicalWords.get(strWord) + 1);
                    } else {
                        identicalWords.put(strWord, 1);
                    }
                }
            }
        }
        return getFilterOutput(identicalWords,1).size();
    }

    public List<? extends TextComponent> findSentenceWithMaxWord(TextComponent component) throws ComponentException {
        if (component.getSentenceType() != SentenceType.TEXT) {
            LOGGER.error("Argument " + component + " is not a text type");
            throw new ComponentException();
        }
        List<Composite> paragraphs = (List<Composite>) component.getChild();
        List<Composite> sentencesWithMaxWord = new ArrayList<>();
        int maxLength = 0;

        for (TextComponent paragraph : paragraphs) {

            List<Composite> sentences = (List<Composite>) paragraph.getChild();

            for (Composite sentence : sentences) {
                List<TextComponent> words = sentence.getChild();

                for (TextComponent word : words) {
                    if (((List<Composite>) word.getChild()).size() > maxLength) {
                        maxLength =((List<Composite>) word.getChild()).size();
                        sentencesWithMaxWord.clear();
                        sentencesWithMaxWord.add(sentence);

                    } else if (((List<Composite>)word.getChild()).size() == maxLength) {
                        sentencesWithMaxWord.add(sentence);
                    }
                }
            }
        }
        LOGGER.info("Sentences with max word: " + sentencesWithMaxWord);
        return sentencesWithMaxWord;
    }
}

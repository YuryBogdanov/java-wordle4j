package ru.yandex.practicum.dictionary;

public class WordComparisonResult {
    private boolean isCorrect;
    private String resultMask;

    public WordComparisonResult(boolean isCorrect, String resultMask) {
        this.isCorrect = isCorrect;
        this.resultMask = resultMask;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getResultMask() {
        return resultMask;
    }

    public void setResultMask(String resultMask) {
        this.resultMask = resultMask;
    }
}

package ru.tinkoff.edu.java.link_parser.data;

public record StackOverflowParserData(int questionId) implements ParserData {
    @Override
    public String toString() {
        return "StackOverflowParserData{" +
                "questionId=" + questionId +
                '}';
    }
}

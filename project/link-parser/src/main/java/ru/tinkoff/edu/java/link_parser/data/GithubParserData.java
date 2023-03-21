package ru.tinkoff.edu.java.link_parser.data;

public record GithubParserData(String user, String repository) implements ParserData {
    @Override
    public String toString() {
        return "GithubParserData{" +
                "user='" + user + '\'' +
                ", repository='" + repository + '\'' +
                '}';
    }
}

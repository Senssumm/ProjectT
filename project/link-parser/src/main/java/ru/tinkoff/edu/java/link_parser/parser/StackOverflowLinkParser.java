package ru.tinkoff.edu.java.link_parser.parser;

import ru.tinkoff.edu.java.link_parser.data.StackOverflowParserData;
import ru.tinkoff.edu.java.link_parser.data.ParserData;

import java.util.regex.Pattern;

public class StackOverflowLinkParser extends LinkParser {

    private static final Pattern STACKOVERFLOW_LINK_PATTERN = Pattern.compile(
              "https://stackoverflow.com/questions/\\d+/.+|" +
                    "https://stackoverflow.com/questions/\\d+/|" +
                    "https://stackoverflow.com/questions/\\d+");
    private static final int QUESTION_INDEX = 4;

    @Override
    public ParserData parse(String link) {
        if (!STACKOVERFLOW_LINK_PATTERN.matcher(link).matches())
            return null;

        var data = link.split("/");
        return new StackOverflowParserData(Integer.parseInt(data[QUESTION_INDEX]));
    }


}

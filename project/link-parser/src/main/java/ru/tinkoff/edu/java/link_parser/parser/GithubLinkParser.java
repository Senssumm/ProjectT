package ru.tinkoff.edu.java.link_parser.parser;

import ru.tinkoff.edu.java.link_parser.data.GithubParserData;
import ru.tinkoff.edu.java.link_parser.data.ParserData;

import java.util.regex.Pattern;

public class GithubLinkParser extends LinkParser {

    private static final Pattern GITHUB_LINK_PATTERN = Pattern.compile(
              "https://github.com/[a-zA-z-0-9]+/[a-zA-z-0-9]+/|" +
                    "https://github.com/[a-zA-z-0-9]+/[a-zA-z-0-9]+");
    private static final int USER_INDEX = 3;
    private static final int REPOSITORY_INDEX = 4;

    @Override
    public ParserData parse(String link) {
        if (!GITHUB_LINK_PATTERN.matcher(link).matches())
            return null;

        var data = link.split("/");
        return new GithubParserData(data[USER_INDEX], data[REPOSITORY_INDEX]);
    }
}

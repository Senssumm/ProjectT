package ru.tinkoff.edu.java.link_parser.parser;

import ru.tinkoff.edu.java.link_parser.data.ParserData;

public abstract class LinkParser {

    private LinkParser nextLinkParser;

    public void setNextLinkParser(LinkParser nextLinkParser) {
        this.nextLinkParser = nextLinkParser;
    }

    public ParserData linkManager(String link) {
        if (link != null) {
            var result = parse(link);
            if (result != null)
                return  result;
        }

        if (nextLinkParser != null)
            return nextLinkParser.linkManager(link);

        return null;
    }

    public abstract ParserData parse(String link);

    public static LinkParser getEmpty(){
        return new LinkParser() {
            @Override
            public ParserData parse(String link) {
                return null;
            }
        };
    }
}
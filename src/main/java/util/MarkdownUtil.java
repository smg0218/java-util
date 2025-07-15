package util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownUtil {
    /***
     * md문법을 html문법으로 변경
     * @param markdown : html로 변경되길 원하는 md문법
     * @return : html로 변경된 md문법
     */
    public static String convertToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}

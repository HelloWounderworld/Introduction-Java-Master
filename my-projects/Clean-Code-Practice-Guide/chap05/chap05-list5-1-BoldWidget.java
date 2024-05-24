// Estudo visual do codigo
// Conceito de formatacao e construcao do codigo estilo artigo de texto academico ou jornal
// Boas praticas: A separacao das linhas em branco indica, visualmente, a separacao entre conceitos

package fitness.wikitext.widgets;

import java.util.regex.*;

public class BoldWidget extends ParentWidget {
    public static final String REGEXP = "'''.+?'''";
    private static final Pattern pattern = Pattern.compile("'''(.+?)'''",Pattern.MULTILINE + Pattern.DOTALL);

    public BoldWidget(ParentWidget parent, String text) throws Exception {
        super(parent);
        Matcher match = pattern.matcher(text);
        match.find();
        addChildWidgets(match.group(1));
    }

    public String render() throws Exception {
        StringBuffer html = new StringBuffer("<br>");
        html.append(childHtml()).append("</br>");
        return html.toString();
    }
}

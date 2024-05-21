// Como organiza-los as funcoes dependentes para o programa
// E exatamente a ordem de composicoes de funcoes que se aprende na matematica
// f(g(x))=(f・g)(x)
// X -> Y -> Z
//   g    f -> f(g(x))=(f・g)(x)

public class WikiPageResponder implements SecureResponder {
    protected WikiPage page;
    protected PageData pageData;
    protected String pageTitle;
    protected Request request;
    protected PageCrawler crawler ;

    
}

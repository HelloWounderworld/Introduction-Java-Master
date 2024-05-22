// Como organiza-los as funcoes dependentes para o programa
// E exatamente a ordem de composicoes de funcoes que se aprende na matematica
// f(g(x))=(f・g)(x)
// X -> Y -> Z
//   g    f -> f(g(x))=(f・g)(x)

// Seguindo a Ordenacao Vertial o codigo abaixo esta satisfazendo essa boa pratica

// Em resumo o que se inclui na boa pratica esta: Maneiras como organiza as funcoes dependentes, lembrando a composicao de funcoes matematicas, e Ordenacao vertiacal

public class WikiPageResponder implements SecureResponder {
    protected WikiPage page;
    protected PageData pageData;
    protected String pageTitle;
    protected Request request;
    protected PageCrawler crawler ;

    public Response makeResponse(FitNessContext context, Request request) throws Exception {
        String pageName = getPageNameOrDefault(request, "FrontPage");
        loadPage(pageName, context);
        if (page == null)
            return notFoundResponse(context, request);
        else
            return makePageResponse(context);
    }

    private String getPageNameOrDefault(Request request, String defaultPageName) {
        String pageName = request.getResource();
        if (StringUtil.isBlank(pageName))
            pageName = defaultPageName;

        return pageName;
    }

    protected void loadPage(String resource, FitNesseContext context) throws Exception {
        WikiPagePath path = PathParser.parse(resource);
        crawler = context.root.getPageCrawler();
        crawler.setDeadEndStrategy(new VirtualEnabledPageCrawler());
        page = crawler.getPage(context.root, path);
        if (page != null) pageData = page.getData();
    }

    private Response notFoundResponse(FitNesseContext context, Request request) throws Exception {
        return new NotFoundResponder().makeResponse(context, request);
    }

    private SimpleResponse makePageResponse(FitNesseContext context) throws Exception {
        pageTitle = PathParser.render(crawler.getFullPath(page));
        String html = makeHtml(context);

        SimpleResponse response = new SimpleResponse();
        response.setMaxAge(0);
        response.SetContent(html);
        return response;
    }
}

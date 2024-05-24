// Junto com o espacamento a continuidade vertial indica uma associacao intima.
// Caso de exemplo ruim sobre continuidade vertical.

// Os comentarios inuteis na classe, ReporterConfig, quebram essa intimidade entre a instancia de duas variaveis
public class ReporterConfig {
    /**
     * The class name reporter listener
     */
    private String m_className;

    /**
     * The properties of the reporter listener
     */
    private List<Property> m_properties = new ArrayList<Property>();

    public void addProperty(Property property) {
        m_properties.add(property);
    }
}

// Aqui ja e o caso melhor de se ler, pois cabe num unico espaco de visao, sem a necessidade de se mover tanto os olhos e a cabeca
public class ReporterConfig {
    private String m_className;
    private List<Property> m_properties = new ArrayList<Property>();

    public void addProperty(Property property) {
        m_properties.add(property);
    }
}

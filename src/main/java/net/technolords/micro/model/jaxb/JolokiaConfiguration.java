package net.technolords.micro.model.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "jolokia", namespace = "http://xsd.technolords.net")
public class JolokiaConfiguration {
    private Output output;
    private JsonParentQuery jsonParentQuery;
    private List<JolokiaQuery> jolokiaQueries;

    public JolokiaConfiguration() {
        this.jolokiaQueries = new ArrayList<>();
    }

    @XmlElement (name = "output")
    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @XmlElement (name = "parent-query")
    public JsonParentQuery getJsonParentQuery() {
        return jsonParentQuery;
    }

    public void setJsonParentQuery(JsonParentQuery jsonParentQuery) {
        this.jsonParentQuery = jsonParentQuery;
    }

    @XmlElement (name = "query")
    public List<JolokiaQuery> getJolokiaQueries() {
        return jolokiaQueries;
    }

    public void setJolokiaQueries(List<JolokiaQuery> jolokiaQueries) {
        this.jolokiaQueries = jolokiaQueries;
    }
}

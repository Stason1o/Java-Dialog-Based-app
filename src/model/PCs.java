package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by sbogdanschi on 10/4/2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PCs {

    @XmlElement(name = "pc")
    private List<PC> pcs = null;

    public List<PC> getPcs() {
        return pcs;
    }

    public void setPcs(List<PC> pcs) {
        this.pcs = pcs;
    }
}

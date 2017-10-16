package model.PCModels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
@XmlRootElement
public abstract class PCPart {

    ProducerEnum producer;
    String model;
    String addInfo;

    public ProducerEnum getProducerEnum() {
        return producer;
    }

    public void setProducerEnum(ProducerEnum producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public boolean isEmpty() {
        return model.isEmpty() && addInfo.isEmpty();
    }
}

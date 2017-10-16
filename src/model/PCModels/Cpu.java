package model.PCModels;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
@XmlRootElement
public class Cpu extends PCPart {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("\n\tproducer=").append(producer);
        sb.append(", \n\tmodel='").append(model).append('\'');
        sb.append(", \n\taddInfo='").append(addInfo).append('\'');
        return sb.toString();
    }

}

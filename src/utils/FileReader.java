package utils;

import model.PC;
import model.PCs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by sbogdanschi on 10/4/2017.
 */
public class FileReader {

    public static List<PC> loadFile() {
        try{
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PCs.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PCs pCs = (PCs) jaxbUnmarshaller.unmarshal(file);
            System.out.println(pCs.getPcs());

            return pCs.getPcs();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void save(PCs pcs) {
        try {
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PCs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(pcs, file);
            jaxbMarshaller.marshal(pcs, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

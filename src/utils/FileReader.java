package utils;

import model.PCs;
import model.PC;

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

    private static String PATH = "\\file.xml";

    public static List<PC> loadFile() {
        try{
            System.out.println(System.getProperty("user.dir"));
            File file = new File(System.getProperty("user.dir") + PATH);
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

    public static List<PC> loadFile(File file) {
        try{
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
            File file = new File(System.getProperty("user.dir") + PATH);
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

    public static void save(PCs pcs, String filepath) {
        try {
            File file = new File(filepath);
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

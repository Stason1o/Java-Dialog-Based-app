package model.PCModels;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
public enum ProducerEnum {
    TRANSCEND("TRANSCEND"),
    KINGSTON("KINGSTON"),
    CORSAIR("CORSAIR"),
    SAMSUNG("SAMSUNG"),
    HYNIX("HYNIX"),
    OCZ("OCZ"),
    INTEL("INTEL"),
    NVIDIA("NVIDIA"),
    AMD("AMD"),
    SAPPHIRE("SAPPHIRE"),
    MSI("MSI"),
    ZOTAC("ZOTAC"),
    ASUS("ASUS"),
    BIOSTAR("BIOSTAR"),
    ACORP("ACORP"),
    GIGABYTE("GIGABYTE"),
    MICRO_STAR("MICRO_STAR");

    private String producer;

    ProducerEnum(String producer) {
        this.producer = producer;
    }

    public String getProducer() {
        return this.producer;
    }

    public static ProducerEnum fromString(String text) {
        return Arrays.stream(ProducerEnum.values()).filter(b -> b.producer.equalsIgnoreCase(text)).findFirst().orElse(null);
    }

    public static List<String> asStringList() {
        return Arrays.stream(values()).map(ProducerEnum::getProducer).collect(Collectors.toList());
    }
}

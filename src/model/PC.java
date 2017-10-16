package model;

import model.PCModels.Cpu;
import model.PCModels.GraphicCard;
import model.PCModels.Motherboard;
import model.PCModels.Ram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Created by sbogdanschi on 9/12/2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PC {

    private String pcName;
    private Cpu cpu;
    private Motherboard motherboard;
    private GraphicCard graphicCard;
    private Ram ram;
    private Integer hddSize;
    private Integer powerSupplier;
    private Double price;

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Integer getHddSize() {
        return hddSize;
    }

    public void setHddSize(Integer hddSize) {
        this.hddSize = hddSize;
    }

    public Integer getPowerSupplier() {
        return powerSupplier;
    }

    public void setPowerSupplier(Integer powerSupplier) {
        this.powerSupplier = powerSupplier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC that = (PC) o;
        return Objects.equals(pcName, that.pcName) &&
                Objects.equals(cpu, that.cpu) &&
                Objects.equals(motherboard, that.motherboard) &&
                Objects.equals(graphicCard, that.graphicCard) &&
                Objects.equals(ram, that.ram) &&
                Objects.equals(hddSize, that.hddSize) &&
                Objects.equals(powerSupplier, that.powerSupplier) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcName, cpu, motherboard, graphicCard, ram, hddSize, powerSupplier, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("pcName='").append(pcName).append('\'');
        sb.append(", \ncpu=").append(cpu);
        sb.append(", \nmotherboard=").append(motherboard);
        sb.append(", \ngraphicCard=").append(graphicCard);
        sb.append(", \nram=").append(ram);
        sb.append(", \nhddSize=").append(hddSize);
        sb.append(", \npowerSupplier=").append(powerSupplier);
        sb.append(", \nprice=").append(price);
        return sb.toString();
    }
}

package fr.epita.mnist.datamodel;

public class Image {

    Double label;
    Double[][] data;

    public Double getLabel() {
        return label;
    }

    public void setLabel(Double label) {
        this.label = label;
    }

    public Double[][] getData() {
        return data;
    }

    public void setData(Double[][] data) {
        this.data = data;
    }

    public Image(Double label, Double[][] data) {
        this.label = label;
        this.data = data;
    }
}

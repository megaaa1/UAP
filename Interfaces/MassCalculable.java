package uap.Interfaces;

public interface MassCalculable {
    int DENSITY = 8;            // satuan: gr/cm³
    double THICKNESS = 0.5;     // satuan: cm

    double getMass();           // volume × DENSITY
}

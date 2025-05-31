package uap.Models;

import uap.Bases.Shape;
import uap.Interfaces.*;

public class Torus extends Shape implements ThreeDimensional, PIRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() {
        return (PI * minorRadius * minorRadius) * (2 * PI * majorRadius);
    }

    @Override
    public double getSurfaceArea() {
        return (4 * PI * PI) * majorRadius * minorRadius;
    }

    @Override
    public double getMass() {
        return getSurfaceArea()*THICKNESS * DENSITY;
    }

    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }

    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG;
    }

     @Override
        public void printInfo() {
            System.out.printf("Volume          : %.2f cm^3\n", getVolume());
            System.out.printf("Luas permukaan  : %.2f cm^2\n", getSurfaceArea());
            System.out.printf("Massa           : %.2f gr\n", getMass());
            System.out.printf("Massa dalam kg  : %.2f kg\n", gramToKilogram());
            System.out.printf("Biaya kirim     : Rp %.0f\n", calculateCost());
        }
}

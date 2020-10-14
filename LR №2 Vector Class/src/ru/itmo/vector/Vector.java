package ru.itmo.vector;

class Vector {
    double x;
    double y;
    double z;

    public Vector(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector[] randVectors(int quantity){
        Vector[] vectors = new Vector[quantity];
        for(int i=0; i<quantity; ++i){
            vectors[i] = new Vector(Math.random()*10, Math.random()*10, Math.random()*10);
        }
        return vectors;
    }

    @Override
    public String toString() {
        return new String("{"+x+", "+y+", "+z+"}");
    }

    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double scalarProd(Vector another){
        return (this.x*another.x + this.y*another.y + this.z*another.z);
    }

    public Vector vectorProd(Vector another){
        return new Vector(
                this.y * another.z - this.z * another.y,
                this.z * another.x - this.x * another.z,
                this.x * another.y - this.y * another.x
        );
    }

    public Vector vectorSum(Vector another){
        return new Vector(
                this.x + another.x,
                this.y + another.y,
                this.z + another.z
        );
    }

    public Vector vectorSub(Vector another){
        return new Vector(
                this.x - another.x,
                this.y - another.y,
                this.z - another.z
        );
    }

    public double angle(Vector another){
        return this.scalarProd(another) / (this.length()*another.length()) * 180/Math.PI;
    }
}
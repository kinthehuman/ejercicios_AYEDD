package ayedd.examenFinal;

public class Vector {
    private int[] coordinates;

    public Vector (int[] elems){
      coordinates = new int[elems.length];
      for (int i = 0; i < elems.length; i++){
          coordinates[i] = elems[i];
      }
    }

    public int scalarProduct (Vector v){
        int result = 0;
        if (v == null){return result;}
        if (this.coordinates.length != v.coordinates.length){
            return result;
        }
        else{
            for (int i = 0; i < this.coordinates.length; i++){
                result = result + this.coordinates[i]*v.coordinates[i];
            }
            return result;
        }
    }

    public String toString(){
        String output = "{";
        for (int i = 0; i < this.coordinates.length; i++){
            output = output + this.coordinates[i];
            if (i != this.coordinates.length - 1){
                output = output + ",";
            }
        }
        output = output + "}";
        return output;
    }
}

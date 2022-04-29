public class ClassOfFunctions {

    private double []array;
    private int size;  // holds the current size of array



    public void initializeArray(double[] list, int size){
        this.size = size;
        array = new double[size];
        if (size >= 0) System.arraycopy(list, 0, array, 0, size);
    }

    public double findMax (){
        double max = array[0];
        for (int i=1; i<size;++i) {
            if (array[i] > max) max =array[i];
        }
        return max;
    }

    public double findMin (){
        double max = array[0];
        for (int i=1; i<size;++i) {
            if (array[i] < max) max =array[i];
        }
        return max;
    }

    public String checkEvenOrOdd(int number){
        if (number %2 == 0) return "Even";
        else return "Odd";
    }
}

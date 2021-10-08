package week4;


public class BayviewGlenPool {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;
    //    final int linearCost = 2;

     //   double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight);
        System.out.println(surfaceArea);
        
    }
    private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition,  int deepHeight) {
        double transitionLength = Math.sqrt((Math.pow(transition, 2)) - (Math.pow(deepHeight-shallowHeight,2)));
        double deepLength = length - shallowLength - transitionLength;
        int shallowEnd = shallowHeight * width;
        int deepEnd = deepHeight * width;
        double bottom = (deepLength + transition + shallowLength) * width;
        double side = shallowHeight * shallowLength + deepHeight * deepLength + transitionLength * shallowHeight
              + (deepHeight - shallowHeight) * transitionLength * 0.5;
  
        return shallowEnd + deepEnd + bottom + side * 2;
    
    }
    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition, int deepHeight) {
        double volumeShallow = shallowLength*width*shallowHeight;
        double transitionLength = Math.sqrt((Math.pow(transition, 2)) - (Math.pow(deepHeight-shallowHeight,2)));
        double deepLength = length - shallowLength - transitionLength;
        double volumeDeep = deepHeight*width*deepLength;
        double volumeTransition = (transitionLength*width*shallowHeight) + ((transitionLength*(deepHeight-shallowHeight))/2)*width;
        return volumeShallow+volumeDeep+volumeTransition;
    }
}

